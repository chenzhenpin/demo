package com.example.demo;

import com.example.demo.quartz.QuartzScheService;
import com.example.demo.quartz.job.TestJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuartzTest {
    @Autowired
    QuartzScheService quartzScheService;



    @Test
    public void test1() {
        quartzScheService.addJob("testJobName", TestJob.class,"*/5 * * * * ?");
        System.out.println("添加定时器5秒，延迟15秒");
        try {
            Thread.sleep(15*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        quartzScheService.modifyJobTime("testJobName","*/1 * * * * ?");
        System.out.println("修改定时器1秒，延迟5秒");
        try {

            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        quartzScheService.pauseJob("testJobName");
        System.out.println("暂停定时器，延迟5秒");
        try {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        quartzScheService.resumeJob("testJobName");
        System.out.println("恢复定时器，延迟5秒");
        try {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        quartzScheService.startJobs();
        System.out.println("启动定时器，延迟5秒");
        try {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        quartzScheService.removeJob("testJobName");
        System.out.println("删除定时器，延迟5秒");
        try {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        quartzScheService.shutdownJobs();
        System.out.println("终止定时器，延迟5秒");
        try {
            Thread.sleep(5*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
