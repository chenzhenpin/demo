package com.example.demo.repository;

import com.example.demo.dataobject.mongoDoc.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,Long> {
}
