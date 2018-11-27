package com.example.demo.controller;

import com.example.demo.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("security")
public class SecurityController {
    @RequestMapping("index")
    @ResponseBody
    public String index(LoginForm loginForm){
        return "index";
    }
     @RequestMapping("toLogin")
    @ResponseBody
    public String toLogin(LoginForm loginForm){
        return "toLogin";
    }
}
