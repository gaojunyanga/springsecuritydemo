package com.glls.order.feign;

import com.glls.common.entity.Order;
import com.glls.order.fallback.StockFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stock",fallback = StockFeignServiceFallBack.class,qualifier = "stock")
public interface StockFeignService {
    @RequestMapping(value = "/stock/updateStock",method = RequestMethod.POST)
    Integer updateStock(Order order);


    @RequestMapping(value = "/stock/testStock",method = RequestMethod.GET)
    String testStock();




}
