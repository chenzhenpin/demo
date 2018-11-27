package com.example.demo.dataobject.mybaitsTable;

//import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("user")
@Data
public class User {
    //@NumberFormat(style=Style.NUMBER)//注解方式数据转换
    private Integer id;
    private String sex;
    private String name;
    //@Range(min=15,max=60,message="年龄必须在15岁到60岁之间")
    private Integer age;
    private String username;
    //@Length(min=6,max=8,message="密码必须在6到8位之间")
    private String password;
    //@DateTimeFormat(pattern="yyyy-MM-dd")//注解方式数据转换
    private Date birthdate;
    public User(){

    };
    public User(Integer id,String name,String sex,Integer age){
        super();
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
    }
}
