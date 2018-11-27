package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.jpaEntity.FAccount;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.jpaService.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
public class AccountServiceImpl implements AccountService{
    @Autowired AccountRepository accountRepository;
    @Override
    public FAccount findOne(Long id) {
        return accountRepository.findByAccountId(id);
    }

    @Override
    @Transactional
    public void remove(Long id ) {
        accountRepository.delete(id);
    }
}
