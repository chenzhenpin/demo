package com.example.demo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "com.example.demo.dataobject.mapper")
//@FixMethodOrder(MethodSorters.JVM) //测试用例执行顺序是不可预测的
//@FixMethodOrder(MethodSorters.NAME_ASCENDING) //测试用例执行按顺序执行
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
