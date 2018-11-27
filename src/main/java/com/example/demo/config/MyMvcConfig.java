package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//本次未测试成功
@Configuration
@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    //设置视图

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //对外暴露的文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //registry.addResourceHandler("/assets").addResourceLocations("classpath:/assets/");
    }

    //请求路径匹配对应视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/security/login").setViewName("securityLogin");
        registry.addViewController("/security/index").setViewName("securityIndex");
    }

    //请求路径支持.字符
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }


}
