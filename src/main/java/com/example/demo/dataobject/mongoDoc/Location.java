package com.example.demo.dataobject.mongoDoc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Location implements Serializable {
    private static final long serialVersionUID = -1868341675558765501L;
    @Id
    private Long id;
    private String addr;

    public Location() {
    }
}
