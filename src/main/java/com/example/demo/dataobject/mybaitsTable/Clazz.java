package com.example.demo.dataobject.mybaitsTable;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("clazz")
@Data
public class Clazz {
    private Integer id;
    private String code;
    private List<Student> students;
    private List<Course> courses;
}
