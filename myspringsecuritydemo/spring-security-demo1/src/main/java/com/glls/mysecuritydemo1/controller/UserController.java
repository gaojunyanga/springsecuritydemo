package com.glls.mysecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UserController
 * @Author : glls
 * @Date: 2021/5/27 16:29
 * @Description :
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/findAll")
    public String findAll(){
        return "findAll";
    }

    @GetMapping("/anno")
    public String anno(){
        return "不需要认证可以访问";
    }


}
