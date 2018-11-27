package com.example.demo.controller;

import com.example.demo.amqp.AmqpSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TempController {
    @Autowired
    AmqpSend amqpSend;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/index.html")
    public String index(){  //必须填写表单参数
        return "index";
    }
    @GetMapping("/moc")
    @ResponseBody
    public String moc(){  //必须填写表单参数
        return "hello word";
    }
    @GetMapping("amqp")
    @ResponseBody
    public String amqp(){
        try {
            amqpSend.sendMsg("amqp问候");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
