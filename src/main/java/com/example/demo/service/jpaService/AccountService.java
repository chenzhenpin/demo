package com.example.demo.service.jpaService;

import com.example.demo.dataobject.jpaEntity.FAccount;

public interface AccountService {
    FAccount findOne(Long id);
    void remove(Long id);
}
