package com.example.demo.quartz.Impl;

import com.example.demo.quartz.QuartzScheService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
@Service
public class QuartzSeviceImpl implements QuartzScheService {
    private static String JOB_GROUP_NAME = "JOB_GROUP_SYSTEM";
    private static String TRIGGER_GROUP_NAME = "TRIGGER_GROUP_SYSTEM";

    @Autowired @Qualifier("Scheduler")
    private Scheduler sched;

    @Override
    public void addJob(String jobName, Class cls, String cron) {

        try {
            JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);// 任务名，任务组，任务执行类
            @SuppressWarnings("unchecked")
            JobDetail jobDetail = newJob(cls).withIdentity(jobKey).build();
            TriggerKey triggerKey = new TriggerKey(jobName, TRIGGER_GROUP_NAME);// 触发器
            Trigger trigger = newTrigger().withIdentity(triggerKey)
                    .withSchedule(cronSchedule(cron)).build();// 触发器时间设定
            sched.scheduleJob(jobDetail, trigger);
            if (!sched.isShutdown()) {
                sched.start();// 启动
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param jobName
     * @param time
     */
    @SuppressWarnings("rawtypes")
    public  void modifyJobTime( String jobName,
                                     String time) {
        try {
            TriggerKey triggerKey = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);
                JobDetail jobDetail = sched.getJobDetail(jobKey);
                Class objJobClass = jobDetail.getJobClass();
                removeJob(jobName);
                System.out.println("修改任务："+jobName);
                addJob(jobName, objJobClass, time);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void pauseJob(String jobName){
        try {

            JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);
            sched.pauseJob(jobKey);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  void resumeJob(String jobName){
        try {

            JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);
            sched.resumeJob(jobKey);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
     *
     *            调度器
     * @param jobName
     *
     * @Title: QuartzManager.java
     */
    public  void removeJob( String jobName) {
        try {
            TriggerKey triggerKey = new TriggerKey(jobName, TRIGGER_GROUP_NAME);
            sched.pauseTrigger(triggerKey);// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            JobKey jobKey = new JobKey(jobName, JOB_GROUP_NAME);
            sched.deleteJob(jobKey);// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public  void startJobs() {
        try {
            sched.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public  void shutdownJobs() {
        try {
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
