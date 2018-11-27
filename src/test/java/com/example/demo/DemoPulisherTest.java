package com.example.demo;

import com.example.demo.event.DemoPulisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoPulisherTest {
    @Autowired
    private DemoPulisher demoPulisher;
    @Test
    public void test1(){
        demoPulisher.pulish("测试事件");
    }
}
