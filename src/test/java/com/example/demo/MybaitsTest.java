package com.example.demo;

import com.example.demo.dataobject.mybaitsTable.Course;
import com.example.demo.dataobject.mybaitsTable.Student;
import com.example.demo.dataobject.mybaitsTable.User;

import com.example.demo.service.mybaitsService.TestService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional//事务
@Rollback //回滚，只用于测试
public class MybaitsTest {

    @Autowired
    TestService testService;

    @Test
    public void test1() {
//        testService.saveUser(new User(43,"林","女",37));
        List<User> users = testService.selectAllUser();
        for (User user : users) {
            System.out.println(user.getAge());
        }


//        Course course= testService.selectCourseById(1);
//       List<Student> students=course.getStudents();
//       for (Student student:students){
//           System.out.println(student.getName());
//       }

    }

}
