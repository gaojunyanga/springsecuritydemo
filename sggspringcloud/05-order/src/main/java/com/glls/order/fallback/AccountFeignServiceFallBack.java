package com.glls.order.fallback;

import com.glls.common.entity.Order;
import com.glls.order.feign.AccountFeignService;
import org.springframework.stereotype.Component;

@Component
public class AccountFeignServiceFallBack implements AccountFeignService {
    @Override
    public Integer updateAccount(Order order) {
        return null;
    }

    @Override
    public String testAccount() {
        return "远程调用account托底数据";
    }
}
