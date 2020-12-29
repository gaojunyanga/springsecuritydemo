package com.glls.order.fallback;

import com.glls.common.entity.Order;
import com.glls.order.feign.StockFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StockFeignServiceFallBack implements StockFeignService {

    @Override
    public Integer updateStock(Order order) {
        return null;
    }

    @Override
    public String testStock() {
        log.info("熔断方法调用.....");
        return "远程调用stock托底数据";
    }
}
