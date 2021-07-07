package com.glls.springsecuritydemo3.controller;

import com.glls.springsecuritydemo3.pojo.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
            // static 中的页面可以直接访问  http://localhost:8080/login.html   unauth.html 在static 中
            return "unauth";
        }


    @RequestMapping("/main")
    @ResponseBody
    public String success(){
        return "main";
    }


    @GetMapping("/unauth")
    public String accessDenyPage(){
        return "unauth";
    }


    // 测试注解
    @RequestMapping("/testSecured")
    @ResponseBody
    @Secured({"ROLE_普通用户1","ROLE_管理员"})
    public String helloUser() {
        return "hello,user";
    }

    @RequestMapping("/preAuthorize")
    @ResponseBody
//@PreAuthorize("hasRole('ROLE_管理员')")
    @PreAuthorize("hasAnyAuthority('menu:system')")
    public String preAuthorize(){
        System.out.println("preAuthorize");
        return "preAuthorize";
    }


    @RequestMapping("/testPostAuthorize")
    @ResponseBody
    @PostAuthorize("hasAnyAuthority('menu:system')")
    public String postAuthorize(){
        System.out.println("test--PostAuthorize");
        return "PostAuthorize";
    }



    @RequestMapping("/testPostFilter")
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PostFilter("filterObject.username == 'admin1'")
    @ResponseBody
    public List<Users> getAllUser(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(1,"admin1","6666"));
        list.add(new Users(2,"admin2","888"));
        return list;
    }


    @RequestMapping("/testPreFilter")
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PreFilter(value = "filterObject.id%2==0")
    @ResponseBody
    public List<Users> getTestPreFilter(@RequestBody List<Users>
                                                   list){
        list.forEach(t-> {
            System.out.println(t.getId()+"\t"+t.getUsername());
        });
        return list;
    }

}
