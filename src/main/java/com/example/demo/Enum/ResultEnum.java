package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "成功");
    private Integer code;

    private String message;
    ResultEnum(int code, String message){
        this.code=code;
        this.message=message;
    }
}
