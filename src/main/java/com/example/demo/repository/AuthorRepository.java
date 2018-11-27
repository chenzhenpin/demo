package com.example.demo.repository;

import com.example.demo.dataobject.mongoDoc.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


public interface AuthorRepository extends MongoRepository<Author,Long> {
}
