package com.example.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RegisterForm {
    @Size(min=2, max=30,message = "长度2-30")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String name;
    @Length(min=6,max=8,message="密码必须在6到8位之间")
    private  String password;




}
