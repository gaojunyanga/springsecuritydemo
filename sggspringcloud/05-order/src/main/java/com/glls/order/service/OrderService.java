package com.glls.order.service;

import com.glls.common.entity.Order;

import java.sql.SQLException;

public interface OrderService {
    int addOrder(Order order) throws SQLException;

    void readManyTimes(Integer orderId);

}