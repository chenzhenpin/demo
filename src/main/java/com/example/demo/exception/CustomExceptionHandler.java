package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ModelAndView WebExceptionHandler( CustomException exception){
        System.out.println("错误信息:"+exception.getMessage());
        ModelAndView mv= new ModelAndView();
        mv.setViewName("redirect:/myError");
        mv.addObject("msg",exception.getMessage());
        return mv;
    }
}
