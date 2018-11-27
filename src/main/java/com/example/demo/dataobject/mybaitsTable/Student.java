package com.example.demo.dataobject.mybaitsTable;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("student")
@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Clazz clazz;
    private Card card;
    private List<Course> Courses;
}
