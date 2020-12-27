package com.glls.order.feign;

import com.glls.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account")
public interface AccountFeignService {
    @RequestMapping
    Integer updateAccount(Order order);
}
