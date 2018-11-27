package com.example.demo.dataobject.mongoDoc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Comment implements Serializable {
    private static final long serialVersionUID = 1756970845763016356L;
    @Id
    private Long id;
    @DBRef
    private Author author;
    private String text;

    public Comment() {
    }
}
