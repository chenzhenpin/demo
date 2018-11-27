package com.example.demo.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPulisher {
    @Autowired
    ApplicationContext applicationContext;
    public void pulish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}
