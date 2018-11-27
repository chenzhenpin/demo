package com.example.demo.service.jpaService;

import com.example.demo.dataobject.ShiroEntity.ShiroUser;

public interface ShiroService {
    ShiroUser findByUserId(Long id);
    ShiroUser findFirstByUsername(String username);
    void registerUser(ShiroUser user);
}
