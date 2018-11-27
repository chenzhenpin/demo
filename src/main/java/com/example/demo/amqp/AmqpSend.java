package com.example.demo.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmqpSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public AmqpSend(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMsg(String content) throws Exception{

         rabbitTemplate.convertAndSend("my-queue","来自rabbitmp的消息"+content);
         rabbitTemplate.convertAndSend("exchange","topic.message","你好");
         rabbitTemplate.convertAndSend("exchange","topic.messages","你好");
    }

}
