package com.glls.order.feign;

import com.glls.common.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account")
public interface AccountFeignService {
    @RequestMapping(value = "/account/updateAccount",method = RequestMethod.POST)
    Integer updateAccount(Order order);
}
