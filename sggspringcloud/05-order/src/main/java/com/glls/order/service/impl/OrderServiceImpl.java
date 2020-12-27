package com.glls.order.service.impl;

import com.glls.common.entity.Order;
import com.glls.order.feign.AccountFeignService;
import com.glls.order.feign.StockFeignService;
import com.glls.order.mapper.AccountMapper;
import com.glls.order.mapper.OrderMapper;
import com.glls.order.mapper.StockMapper;
import com.glls.order.service.OrderService;
import com.glls.order.service.StockService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private StockService stockService;


    @Override
    //@Transactional(rollbackFor = Exception.class)
    @Transactional(propagation = Propagation.REQUIRED)
    public int addOrder(Order order)  {
//        System.out.println(AopUtils.isCglibProxy("111111111"+this));
//        System.out.println(AopUtils.isJdkDynamicProxy("33333333"+this));
//        System.out.println(AopUtils.isAopProxy("4444444"+this));
        // 添加订单
        int result = orderMapper.addOrder(order);

        //int i =10/0;
        //throw new SQLException("数据库异常");   // 检查时异常   不可触发事务回滚  需要加上 rollbackFor
        //throw new RuntimeException ("数据库异常");   //运行时异常  可回滚


//        try {
//            //throw new SQLException("数据库异常");
//            throw new RuntimeException ("数据库异常");
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//        }


        //---- 扣减库存    本类事务方法互调  被调用的方法事务配置失效
//        for(int i=0;i<2;i++){
//            int result2 = updateStock(order);
//        }

        // ---本类 事务方法互调生效   使用aspectj
         OrderServiceImpl o = (OrderServiceImpl) AopContext.currentProxy();
//
        System.out.println(AopUtils.isCglibProxy(o));
        System.out.println(AopUtils.isJdkDynamicProxy(o));
        System.out.println(AopUtils.isAopProxy(o));

        //for(int i=0;i<2;i++){
             //获取代理对象
            int result2 = o.updateStock(order);
            // result2 = o.updateStock(order);

        //}

        //---- 规范  是 service 之间 互相调用  service 不要直接调用 别的 dao 比如直接 调 stock 的 mapper
       /* for(int i=0;i<2;i++){
            int result2 = stockService.updateStock(order);
        }*/

        // 扣减账户
        o.updateAccount(order);
        return result;
    }


    /**
     * 调用 同一个类 内部的 方法 这个方法上的事务配置默认不会生效
     * 比如 当前类 调 A 方法   ，A 方法 调B方法 ， B方法上的事务配置会被A 方法上的事务配置覆盖掉，即
     * 第一个调用的方法 事务配置生效， 原因是 因为  A 调用B 相当于 把B 的方法内容粘贴进了 A ,没有通过
     * 代理对象去调用
     *
     * @Transactional(xxx)
     * a(){
     *
     *     b();
     *     c();
     *     这样调用本类内部的方法  b  和 c 上面的事务不会生效 相当于  相当于 直接把b 和 c 的代码 放在a 内部 跟a 共用用一个事务
     *     bbbb
     *     cccc
     * }
     * @Transactional(yyy)
     * b(){
     *     bbbb
     * }
     * @Transactional(zzz)
     * c(){
     *     cccc
     * }
     *
     * 同一个对象内部事务方法互调 默认失效  原因是绕过了代理对象，所以咱们希望用 代理对象调用  于是
     * @Autowired
     * OrderService orderService;  // 自己注入自己
     * orderService.b();
     * orderService.c();
     * 思路 是对的 但是这样做 就会出现 循环依赖问题
     * 所以 怎么做？
     * 换一种代理对象的生成方式   aspectJ 动态代理 ,  默认走的是  jdk 的 接口动态代理
     * 换成  aspectj
     * 1. 引入 starter-aop 依赖
     *      <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-aop</artifactId>
     *         </dependency>
     * 2.开启 aspectj 的动态代理  ，默认 使用的是 基于JDK 的 接口动态代理
     *      现在换成 aspectj的动态代理 好处是 没有接口 也可以动态代理
     *  @EnableAspectJAutoProxy(exposeProxy = true)  开启aspectJ 动态代理 ，并暴露代理对象
     *
     * 3. 本类内部方法互调  使用代理对象  那么怎么获取代理对象？
     *      AopContext
     *
     * */
    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public int updateStock(Order order) {
       // int i = 5/0;
        return stockMapper.updateStock(order);

    }
    @Transactional(propagation = Propagation.REQUIRES_NEW )
    public int updateAccount(Order order){

        return accountMapper.updateAccount(order);
    }

    // 测试 消息的 隔离级别
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)    // 避免 不可重复度问题
    //@Transactional(isolation = Isolation.READ_COMMITTED)   // 存在 不可重复读问题
    public void readManyTimes(Integer orderId) {
        Order order = orderMapper.findOrderById(orderId);
        //在这里 打断点   去数据库 修改这条数据
        System.out.println(order);


        System.out.println("----------");
        // 对比 和上面读到的数据是个否一致   记得去除mybatis 的 查询缓存设置 在配置文件 加 flushCache="true"
        Order order2 = orderMapper.findOrderById(orderId);

        System.out.println(order);

    }

    @Autowired
    private StockFeignService stockFeignService;
    @Autowired
    private AccountFeignService accountFeignService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addOrder2(Order order) {
        // 添加订单
        int result = orderMapper.addOrder(order);

        // 扣减库存
        Integer result2 = stockFeignService.updateStock(order);

        // 扣减账户
        Integer result3 = accountFeignService.updateAccount(order);

        return result3;
    }


}
