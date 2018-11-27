package com.example.demo.exception;


import com.example.demo.Enum.ExceptionEnum;

public class CustomException extends RuntimeException {
	private Integer code;
	//异常信息
	public CustomException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());

		this.code = exceptionEnum.getCode();
	}

	public CustomException(Integer code, String message) {
		super(message);
		this.code = code;
	}
	

}
