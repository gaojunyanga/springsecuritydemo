package com.glls.account.service.impl;

import com.glls.account.mapper.AccountMapper;
import com.glls.account.service.AccountService;
import com.glls.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateAccount(Order order) {
        return accountMapper.updateAccount(order);
    }
}
