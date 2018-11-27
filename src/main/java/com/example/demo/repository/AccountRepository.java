package com.example.demo.repository;

import com.example.demo.dataobject.jpaEntity.FAccount;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "account")
public interface AccountRepository extends JpaRepository<FAccount,Long> {
    //http://127.0.0.1:8085/account/search/findByAccountId?id=3
    @RestResource(path = "findByAccountId",rel = "findByAccountId")
    FAccount findByAccountId(@Param("id") Long id) ;
}
