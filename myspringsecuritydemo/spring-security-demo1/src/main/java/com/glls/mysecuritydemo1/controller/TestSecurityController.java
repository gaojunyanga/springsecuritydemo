package com.glls.mysecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TestSecurityController
 * @Author : glls
 * @Date: 2021/5/26 19:58
 * @Description :
 */
@RestController
public class TestSecurityController {

    @GetMapping("/index")
    public String index(){
        return "success";
    }


    @RequestMapping("/add")
    public String add(){
        return "hello security!";
    }


}
