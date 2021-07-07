package com.glls.springsecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecurityController {

    @GetMapping("/index")
    public String index(){
        return "success123456";
    }
}
