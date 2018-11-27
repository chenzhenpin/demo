package com.example.demo;


import com.example.demo.amqp.AmqpSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {
    @Autowired
    private AmqpSend amqpSend;
    @Test
    public void amqpTest() {
        try {
            amqpSend.sendMsg("你好");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
