package com.example.demo.controller;

import com.example.demo.Enum.ExceptionEnum;
import com.example.demo.Enum.ResultEnum;
import com.example.demo.dataobject.mybaitsTable.User;
import com.example.demo.exception.WebException;
import com.example.demo.service.mybaitsService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MybaitsController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/inseruser")
    @ResponseBody
    public ResultEnum inserUser(){
        User user=new User(22,"平","男",38);
        try {
            testService.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new WebException(ExceptionEnum.ERROR_SQL);
        }

        return ResultEnum.SUCCESS;
    }
    @ResponseBody
    @RequestMapping(value = "/myError")
    public String myError(@RequestParam("msg") String msg){
        System.out.println("msg");
        return msg;
    }
}
