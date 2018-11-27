package com.example.demo;

import com.example.demo.dataobject.mongoDoc.Author;
import com.example.demo.dataobject.mongoDoc.Comment;
import com.example.demo.dataobject.mongoDoc.Location;
import com.example.demo.dataobject.mongoDoc.Post;
import com.example.demo.service.mongoService.MongoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    MongoService mongoService;
    @Test
    public void insertLocation(){
        Location location =new Location();
        location.setAddr("海口");
        location.setId(Long.valueOf(213213));
        mongoService.insertLocation(location);
    }
    @Test
    public void findLocationAll(){
        List<Location>locationList=mongoService.findLocationAll();
        for (Location location:locationList){
            System.out.println(location.getAddr());
        }
    }


    @Test
    public void insertPost(){
        //@DBRef标志的属性都要先保存，否则插入查询相应值为空，不是@DBRef标志的属性则无需保存，将以数组的形式存储全部值。
        List<Location>locationList=mongoService.findLocationAll();



        Location location1 =new Location();
        location1.setAddr("万宁");
        location1.setId(Long.valueOf(213214));
        Location location2 =new Location();
        location2.setAddr("三亚");
        location2.setId(Long.valueOf(213215));


        mongoService.insertLocation(location1);
        mongoService.insertLocation(location2);


//        Location location3 =new Location();
//        location3.setAddr("陵水");
//        location3.setId(Long.valueOf(213216));  //不先保存，则不能查询该条记录

        Author author1= new Author();
        author1.setAge(12);
        author1.setId(Long.valueOf(11));
        author1.setName("陈");
        author1.getLocations().add(location1);
        author1.getLocations().add(location2);
//        author1.getLocations().add(location3);
        for (Location location:locationList){
            author1.getLocations().add(location);
        }
        Author author2= new Author();
        author2.setAge(24);
        author2.setId(Long.valueOf(12));
        author2.setName("林");
        author2.getLocations().add(location1);

        mongoService.insertAuthor(author1);
        mongoService.insertAuthor(author2);

//        Author author3= new Author();
//        author3.setAge(35);
//        author3.setId(Long.valueOf(13));
//        author3.setName("刘");
//        author3.getLocations().add(location2);

        Comment comment =new Comment();
        comment.setAuthor(author1);
        comment.setId(Long.valueOf(11));
        comment.setText("很好");

        Comment comment1 =new Comment();
        comment1.setAuthor(author2);
        comment1.setId(Long.valueOf(12));
        comment1.setText("很差");


        mongoService.insertComment(comment);
        mongoService.insertComment(comment1);




        Post post = new Post();
        post.setId(Long.valueOf(11));
        post.setTitle("标题1");
        post.setContent("内容1");
        post.setAuthor(author1);
        post.getComments().add(comment);
        post.getComments().add(comment1);

        Post post1 = new Post();
        post1.setId(Long.valueOf(12));
        post1.setTitle("标题2");
        post1.setContent("内容2");
        post1.setAuthor(author2);
        post1.getComments().add(comment1);

        mongoService.insertPost(post);
        mongoService.insertPost(post1);


    }
    @Test
    public void findPostAll(){
       List<Post> posts= mongoService.findPostAll();
       for (Post post : posts){
           System.out.println(post.getTitle());
           for (Comment comment : post.getComments()){
               System.out.println(comment.getText());
               System.out.println(comment.getAuthor().getAge());
           }
           System.out.println(post.getAuthor().getName());
           System.out.println(post.getTitle());
           System.out.println();
       }
    }

}
