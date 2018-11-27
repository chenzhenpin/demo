package com.example.demo;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@Configuration
@SpringBootApplication
@EnableScheduling//定时任务

public class DemoApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    //打war需要
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(DemoApplication.class);
//    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8085);
    }

    //设置未生效
//	@Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
//        viewResolver.setPrefix("classpath:/static/templates");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        System.out.println("设置视图");
//        return viewResolver;
//    }
//    @Bean
//    public MultipartResolver multipartResolver(){
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(1024*1024);
//        return multipartResolver;
//    }

    //rabbitmp Queue
    @Bean
    public Queue wiselyQueue(){
        return new Queue("my-queue");
    }
    @Bean(name="message")
        public Queue queueMessage() {
            return new Queue("topic.message");
    }
    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("messages") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
