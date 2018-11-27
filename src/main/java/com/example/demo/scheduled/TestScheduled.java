package com.example.demo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TestScheduled {
//    public final static long SECOND = 1 * 1000;
//    @Scheduled(cron = "0 0 1 * * ? ")
//    public void addUserGold() {
//        System.out.println("凌晨一点了，你睡了么？");
//    }
//
//    /**
//     * 每隔5秒定时清理缓存
//     */
//
////    @Scheduled(cron = "*/5 * * * * ? ")
////    public void cacheClear() {
////        System.out.println("时间又过去5秒了，真令人伤感...");
////    }
//
//    //固定间隔时间 @Scheduled(fixedRate = 时间间隔 )
//    @Scheduled(fixedRate = SECOND*10)
//    public void fixedRateJob(){
//        System.out.println("每隔10秒钟");
//    }
//    //固定等待时间 @Scheduled(fixedDelay = 时间间隔 )
//    @Scheduled(fixedDelay = SECOND * 2)
//    public void fixedDelayJob() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);
//        System.out.println("固定等待时间2秒");
//    }

}
