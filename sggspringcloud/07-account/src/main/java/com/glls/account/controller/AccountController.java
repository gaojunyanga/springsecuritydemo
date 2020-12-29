package com.glls.account.controller;

import com.glls.account.service.AccountService;
import com.glls.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/updateAccount",method = RequestMethod.POST)
    Integer updateAccount(@RequestBody Order order){
        return accountService.updateAccount(order);
    }


    @RequestMapping(value = "/testAccount",method = RequestMethod.GET)
    String testAccount(){
        return "testAccount";
    }

}
