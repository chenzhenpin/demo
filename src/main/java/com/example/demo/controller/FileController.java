package com.example.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class FileController {
    @GetMapping("test/upload")
    public String getUpload(){
        return "upload";
    }
    @PostMapping("test/upload")
    @ResponseBody
    public String postUpload(@RequestParam("file") MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("e:\\ideawork\\mySpringBoot\\demo\\src\\main\\resources\\static\\upload\\"+file.getOriginalFilename()),file.getBytes());
            return "ok";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }
    @GetMapping("test/path")
    @ResponseBody
    public String path(HttpServletRequest request)  {
        System.out.println("====================");
        System.out.println(request.getServletPath().toString());

        try {
            System.out.println(ResourceUtils.getURL("classpath:"));
            System.out.println(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(ResourceUtils.getFile("F:\\ideawork\\mySpringBoot\\demo\\src\\main\\resources\\static"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("====================");
        return "ok";
    }
}
