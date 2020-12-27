package com.glls.order.feign;

import com.glls.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stock")
public interface StockFeignService {
    @RequestMapping(value = "/stock/updateStock",method = RequestMethod.POST)
    Integer updateStock(@RequestBody Order order);
}
