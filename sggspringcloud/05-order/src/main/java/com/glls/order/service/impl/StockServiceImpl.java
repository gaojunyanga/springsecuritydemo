package com.glls.order.service.impl;

import com.glls.common.entity.Order;
import com.glls.order.mapper.StockMapper;
import com.glls.order.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("stockService")
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateStock(Order order) {
        //int i = 5/0;
        return stockMapper.updateStock(order);
    }
}
