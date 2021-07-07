package com.glls.springsecuritydemo2.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : StudentsController
 * @Author : glls
 * @Date: 2021/5/5 15:03
 * @Description :
 */
@RestController
@RequestMapping("/student")
public class StudentsController {
    /**
     * 测试@Secured注解
     * @return
     */
    @RequestMapping("/items")
    @Secured({"ROLE_student"})
    public String items(){
        return "show items";
    }
    /**
     * 测试@PreAuthorize注解
     * @return
     */
    @RequestMapping("/items2")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String items2(){
        return "show items2";
    }
}
