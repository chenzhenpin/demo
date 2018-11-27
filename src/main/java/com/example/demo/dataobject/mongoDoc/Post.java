package com.example.demo.dataobject.mongoDoc;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//@DBRef标志的属性都要先保存，否则插入查询相应值为空，不是@DBRef标志的属性则无需保存，将以数组的形式存储全部值
@Data
@Document
public class Post implements Serializable {
    private static final long serialVersionUID = -1357468521850775907L;
    @Id
    private Long id;
    private String title;
    private String content;
    @DBRef
    private Author author;
    @DBRef
    private List<Comment> comments = new ArrayList<Comment>();

    public Post() {
    }
}
