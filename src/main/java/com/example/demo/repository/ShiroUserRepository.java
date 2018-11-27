package com.example.demo.repository;

import com.example.demo.dataobject.ShiroEntity.ShiroUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiroUserRepository extends JpaRepository<ShiroUser,Long > {
    ShiroUser findFirstByUserId(long id);
    ShiroUser findFirstByUsername(String username);

}
