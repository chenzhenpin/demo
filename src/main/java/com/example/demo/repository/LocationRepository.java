package com.example.demo.repository;

import com.example.demo.dataobject.mongoDoc.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LocationRepository extends MongoRepository<Location,Long>{

}
