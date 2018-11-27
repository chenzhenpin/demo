package com.example.demo.form;

import lombok.Data;

@Data
public class LoginForm {
    private  String username;
    private  String password;
    private  Boolean rememberMe; //该字段是复选框，要使用布尔型
}


