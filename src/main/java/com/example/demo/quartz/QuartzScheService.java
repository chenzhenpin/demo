package com.example.demo.quartz;

import org.quartz.Job;

public interface QuartzScheService {
    public void addJob(String jobName,  Class clazz,String cron);
    public void removeJob(String jobName);
    public void pauseJob(String jobName);
    public void resumeJob(String jobName);
    public  void  modifyJobTime(String jobName,String corn);
    public void startJobs();
    public void shutdownJobs();


}
