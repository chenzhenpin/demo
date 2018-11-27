package com.example.demo.VO;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable{
    @NumberFormat(style = NumberFormat.Style.NUMBER)//注解方式数据转换
    private final ThreadLocal<Integer> id = new ThreadLocal<Integer>();
    private String sex;
    private String name;
    @Range(min=15,max=60,message="年龄必须在15岁到60岁之间")
    private Integer age;
    private String username;
    @Length(min=6,max=8,message="密码必须在6到8位之间")
    private String password;
    @DateTimeFormat(pattern="yyyy-MM-dd")//注解方式数据转换
    private Date birthdate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public UserVO(){
        super();
    }
    public UserVO(String name,String sex,Integer age){
        super();
        this.name=name;
        this.sex=sex;
        this.age=age;
    }
    public UserVO(Integer id,String name,String sex,Integer age){
        super();
        this.id.set(id);
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

}


