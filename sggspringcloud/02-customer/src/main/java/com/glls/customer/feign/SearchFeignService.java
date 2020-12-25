package com.glls.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SEARCH")
public interface SearchFeignService {
    @RequestMapping(value = "/search/search",method = RequestMethod.GET)
    public String search();
}
