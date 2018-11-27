package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.jpaEntity.FPerson;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.jpaService.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{
    @Autowired PersonRepository personRepository;
    @Override
    public FPerson findOne(Long id) {
        return personRepository.findByPersonId(id);
    }
    @Transactional
    public FPerson savePerson(FPerson person) {
        return personRepository.save(person);
        
    }
    @Transactional
    public void remove(Long id){
        personRepository.delete(id);
    }

    @Override
    @Transactional
    public void flush() {
        personRepository.flush();
    }


}
