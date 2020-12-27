package com.glls.order.controller;

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
    public String isolation(Integer orderId){
        orderService.readManyTimes(orderId);
        return "ok";
    }

}
