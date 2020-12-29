package com.glls.order.service;

import com.glls.common.entity.Order;

import java.sql.SQLException;

public interface OrderService {
    int addOrder(Order order) throws SQLException;

    Order readManyTimes(Integer orderId);

    int addOrder2(Order order);

    String test4(String test);

}
