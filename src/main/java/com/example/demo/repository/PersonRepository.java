package com.example.demo.repository;

import com.example.demo.dataobject.jpaEntity.FPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<FPerson,Long> {
    FPerson findByPersonId(Long id) ;
}
