package com.example.demo.service.impl;

import java.io.File;


import com.example.demo.service.AsyncTaskService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.concurrent.ListenableFuture;

import javax.mail.internet.MimeMessage;

@Service
// 线程执行任务类
public class AsyncTaskServiceImpl implements AsyncTaskService{

    @Autowired
    JavaMailSender mailSender;


    // 表明是异步方法
    // 无返回值
    @Async
    public void sendTextMail(String from,String to,String subject,String content)throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);

    }

    @Async
    public void sendAttachmentsMail(String from,String to,String subject,String content) throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content);

        FileSystemResource file = new FileSystemResource(new File(ResourceUtils.getURL("src/main/resources/weixin.png").getPath()));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);

    }

    @Async
    public void sendInlineMail(String from,String to) throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File(ResourceUtils.getURL("src/main/resources/weixin.png").getPath() ));
       // 这里需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);

    }

    @Override
    @Async
    public ListenableFuture<String> sendString(String msg) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        LoggerFactory.getLogger(AsyncTaskServiceImpl.class).info(msg);
        return new AsyncResult<>(msg);
    }
}