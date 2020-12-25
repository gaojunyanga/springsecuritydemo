package com.glls.customer.controller;

import com.glls.customer.feign.SearchFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private SearchFeignService searchFeignService;

    @GetMapping("/customer")
    public String customer(){

        String result = searchFeignService.search();

        // 没有使用  hystrix 的线程池  还是用的 tomcat的线程池
        System.out.println(Thread.currentThread().getName());
        return result;
    }
}
