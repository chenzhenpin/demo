package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import  org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * 开启Spring Data Rest
 */
@Configuration
public class MySpringDataRestConfig  extends RepositoryRestMvcConfiguration{
    @Override
    public RepositoryRestConfiguration config() {
        return super.config();
    }
}
