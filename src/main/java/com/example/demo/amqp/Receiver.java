package com.example.demo.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues ="my-queue")
    public void receiveMsg1(String msg){
        System.out.println("Receiver1"+msg);
    }
    @RabbitListener(queues ="my-queue")
    public void receiveMsg2(String msg){
        System.out.println("Receiver2"+msg);
    }

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
//    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
//    public void process2(String str) {
//        System.out.println("messages1:"+str);
//    }
//    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
//    public void process3(String str) {
//        System.out.println("messages2:"+str);
//    }
}
