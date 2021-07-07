package com.glls.springsecuritydemo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : UsersController
 * @Author : glls
 * @Date: 2021/5/5 10:42
 * @Description :
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @GetMapping("/findAll")
    public String findAll(){
        return "findAll";
    }

    @GetMapping("/find")
    @ResponseBody
    public String find(){
        return "find";
    }



    @GetMapping("/anno")
    public String anno(){
        return "不需要认证可以访问";
    }
}
