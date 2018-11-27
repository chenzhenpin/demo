package com.example.demo.dataobject.mybaitsTable;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("course")
@Data
public class Course {
    private Integer id;
    private String name;
    private List<Clazz> clazzs;
    private List<Student> students;
}
