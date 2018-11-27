package com.example.demo.service.mongoService.impl;

import com.example.demo.dataobject.mongoDoc.Author;
import com.example.demo.dataobject.mongoDoc.Comment;
import com.example.demo.dataobject.mongoDoc.Location;
import com.example.demo.dataobject.mongoDoc.Post;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.mongoService.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoServiceImpl implements MongoService{
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void insertLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public List<Location> findLocationAll() {
        return locationRepository.findAll();
    }

    @Override
    public void insertPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findPostAll() {
        return postRepository.findAll();
    }

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);

    }

    @Override
    public void insertAuthor(Author author) {
        authorRepository.save(author);
    }
}
