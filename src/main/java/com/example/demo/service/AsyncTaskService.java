package com.example.demo.service;

import org.springframework.util.concurrent.ListenableFuture;

public interface AsyncTaskService {
    void sendTextMail(String from,String to,String subject,String content) throws Exception;
    void sendAttachmentsMail(String from,String to,String subject,String content) throws Exception;
    void sendInlineMail(String from,String to) throws Exception;
    ListenableFuture<String> sendString(String msg);
}
