package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4632562194335187114L;
    private String msg;
    public DemoEvent(Object object,String msg){
        super(object);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
