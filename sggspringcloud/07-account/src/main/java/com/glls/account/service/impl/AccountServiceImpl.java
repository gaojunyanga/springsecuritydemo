package com.glls.account.service.impl;

import com.glls.account.mapper.AccountMapper;
import com.glls.account.service.AccountService;
import com.glls.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Integer updateAccount(Order order) {
        return accountMapper.updateAccount(order);
    }
}
