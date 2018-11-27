package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.synth.SynthToggleButtonUI;

@ControllerAdvice
public class WebExceptionHandler {

    /*@ExceptionHandler(value = WebException.class)
    public String WebExceptionHandler(WebException exception){
        System.out.println(exception.getMessage());
        return "false";
    }*/
    @ExceptionHandler(value = WebException.class)
    public ModelAndView  WebExceptionHandler(WebException exception){
        System.out.println("错误信息:"+exception.getMessage());
        ModelAndView mv= new ModelAndView();
        mv.setViewName("redirect:/myError");
        mv.addObject("msg",exception.getMessage());
        return mv;
    }
}
