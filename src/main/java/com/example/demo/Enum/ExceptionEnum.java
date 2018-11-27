package com.example.demo.Enum;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    ERROR_SQL(0, "数据库操作异常");
    private Integer code;

    private String message;
    ExceptionEnum(int code, String message){
        this.code=code;
        this.message=message;
    }
}
