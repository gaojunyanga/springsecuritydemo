package com.glls.order.feign;

import com.glls.common.entity.Order;
import com.glls.order.fallback.AccountFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "account",fallback = AccountFeignServiceFallBack.class,qualifier="account")
public interface AccountFeignService {
    @RequestMapping(value = "/account/updateAccount",method = RequestMethod.POST)
    Integer updateAccount(Order order);


    @RequestMapping(value = "/account/testAccount",method = RequestMethod.GET)
    String testAccount();

}
