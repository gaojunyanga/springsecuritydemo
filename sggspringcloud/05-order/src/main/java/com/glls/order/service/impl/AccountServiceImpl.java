package com.glls.order.service.impl;

import com.glls.common.entity.Order;
import com.glls.order.mapper.AccountMapper;
import com.glls.order.service.AccountService;
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
    public int updateAccount(Order order) {
        return accountMapper.updateAccount(order);
    }

}
