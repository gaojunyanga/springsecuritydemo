package com.glls.springsecuritydemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : IndexController
 * @Author : glls
 * @Date: 2021/5/5 10:40
 * @Description :
 */
@Controller
public class IndexController {



        @GetMapping("/index")
        public String index(){
            //通过controller 跳转的页面 会跳转到  templates 中
            //templates 中的页面  不能 直接访问
            // static 中的页面可以直接访问  http://localhost:8080/login.html   login.html 在static 中
            return "login";
        }


    @RequestMapping("/main")
    public String success(){
        return "main";
    }


}
