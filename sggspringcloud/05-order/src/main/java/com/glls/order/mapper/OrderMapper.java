package com.glls.order.mapper;

import com.glls.common.entity.Order;

public interface OrderMapper {
    int addOrder(Order order);

    Order findOrderById(Integer orderId);
}
