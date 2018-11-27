package com.example.demo.controller;

import com.example.demo.dataobject.mybaitsTable.User;
import com.example.demo.service.mybaitsService.TestService;
import com.example.demo.service.redisService.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class RedisController {
    @Autowired
    TestService testService;
    @Autowired
    RedisService redisService;
    @ResponseBody
    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            System.out.println("生成uuid");
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
    @RequestMapping("/getUser")
    @ResponseBody
    @Cacheable(value="user-key")
    public List<User> getUser() {
        List<User> users=testService.selectAllUser();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }

    @RequestMapping("/getValue")
    @ResponseBody
    public String  getValue() {
        redisService.set("dd","33");
        String v=redisService.get("dd").toString();
        System.out.println(v);
        return v;
    }
}
