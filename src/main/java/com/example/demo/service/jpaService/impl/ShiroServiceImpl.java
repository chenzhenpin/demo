package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.ShiroEntity.ShiroUser;
import com.example.demo.repository.ShiroUserRepository;
import com.example.demo.service.jpaService.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    ShiroUserRepository shiroUserRepository;

    @Override
    public ShiroUser findByUserId(Long id) {
        return shiroUserRepository.findFirstByUserId(id);
    }

    @Override
    public ShiroUser findFirstByUsername(String username) {
        return shiroUserRepository.findFirstByUsername(username);
    }

    @Override
    @Transactional
    public void registerUser(ShiroUser user) {

        shiroUserRepository.save(user);
    }
}
