package com.example.demo.repository;

import com.example.demo.dataobject.jpaEntity.FAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<FAddress,Long> {
}
