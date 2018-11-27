package com.example.demo.dataobject.mongoDoc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
@Data
@Document
public class Author implements Serializable {
    private static final long serialVersionUID = 4800550367393822294L;
    @Id
    private Long id;
    private String name;
    private Integer age;
    // 不使用@DBRef 将插入全部信息
    private Collection<Location> locations=new HashSet<Location>();

    public Author() {
    }
}
