package com.glls.order.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.glls.common.entity.Order;
import com.glls.order.service.OrderService;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/tran1")
    public String localTran(Order order) throws SQLException {
        System.out.println(AopUtils.isCglibProxy(orderService));
        System.out.println(AopUtils.isJdkDynamicProxy(orderService));
        System.out.println(AopUtils.isAopProxy(orderService));
        // 下订单  扣库存  减账户
        int result = orderService.addOrder(order);
        if(result==1){
            return "下单成功";
        }
        return "下单失败";
    }


    @RequestMapping("/iso")
    public Order isolation(Integer orderId){
        // 演示 事务 隔离界别
        Order order = orderService.readManyTimes(orderId);
        return order;
    }


    @RequestMapping("/tran2")
    public String distributedTran(Order order) throws SQLException {
       // 分布式事务
        // 下订单  扣库存  减账户
        int result = orderService.addOrder2(order);
        if(result==1){
            return "下单成功";
        }
        return "下单失败";
    }


    @RequestMapping("/test1")
    public String test1(){
        return "----this is test1";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "----this is test2";
    }

    /**
     * 演示 阈值类型 线程数
     * */
    @RequestMapping("/test3")
    public String test3(){

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----this is test3";
    }

    @RequestMapping("/test4")
    public String test4(String test) throws BlockException {
      return   orderService.test4(test);
    }

}
