package com.example.demo.repository;

import com.example.demo.dataobject.mongoDoc.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,Long> {
}
