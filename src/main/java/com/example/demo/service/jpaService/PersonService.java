package com.example.demo.service.jpaService;

import com.example.demo.dataobject.jpaEntity.FPerson;

public interface PersonService {
    FPerson findOne(Long id);
    FPerson savePerson(FPerson person);
    void remove(Long id );
    void flush();
}
