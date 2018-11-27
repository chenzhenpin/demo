package com.example.demo.quartz.job;

import com.example.demo.quartz.job.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements BaseJob {
    public TestJob(){

    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("测试quartz定时器");
    }
}
