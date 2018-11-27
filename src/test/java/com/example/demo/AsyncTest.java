package com.example.demo;

import com.example.demo.service.AsyncTaskService;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
    @Autowired
    AsyncTaskService asyncTaskService;
    @Test
    public void  test(){
        try{
            System.out.println(ResourceUtils.getURL(ResourceUtils.getURL("src/main/resources/weixin.png").getPath()));
            System.out.println(ResourceUtils.getURL("").getPath());
            System.out.println(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void test1(){
        try {
            asyncTaskService.sendTextMail("1595347682@qq.com","1940497838@qq.com","邮件主题","邮件内容");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

     @Test
    public void test2() {
        try {
            asyncTaskService.sendAttachmentsMail("1595347682@qq.com", "1940497838@qq.com", "邮件主题", "邮件内容");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            asyncTaskService.sendInlineMail("1595347682@qq.com", "1940497838@qq.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4() {
        String msg=null;
        try {
            msg=asyncTaskService.sendString("chen").get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
    }
    @Test
    public void test5() {
        //异步发送避免程序退出
        try{
            Thread.sleep(20*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
