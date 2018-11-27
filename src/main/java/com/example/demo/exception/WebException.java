package com.example.demo.exception;

import com.example.demo.Enum.ExceptionEnum;
import lombok.Getter;

@Getter
public class WebException extends RuntimeException{

    private Integer code;

    public WebException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());

        this.code = exceptionEnum.getCode();
    }

    public WebException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}