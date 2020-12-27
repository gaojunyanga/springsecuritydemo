package com.glls.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.glls.order.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)      // 开启  aspectJ 的 动态代理 并暴露代理对象 之前 默认使用 jdk 的 接口动态代理
public class OrderApplication {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication.class,args);
    }
}
