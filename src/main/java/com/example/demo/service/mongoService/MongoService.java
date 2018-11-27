package com.example.demo.service.mongoService;

import com.example.demo.dataobject.mongoDoc.Author;
import com.example.demo.dataobject.mongoDoc.Comment;
import com.example.demo.dataobject.mongoDoc.Location;
import com.example.demo.dataobject.mongoDoc.Post;

import java.util.List;


public interface MongoService {
    void insertLocation(Location location);
    void insertComment(Comment comment);
    void insertAuthor(Author author);
    void insertPost(Post post);

    List<Location> findLocationAll();
    List<Post> findPostAll();


}
