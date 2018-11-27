package com.example.demo.service.mybaitsService.impl;

import com.example.demo.dataobject.mybaitsTable.User;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.mybaitsService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestMapper testMapper;
    @Override
    public void saveUser(User user) {
        if (user !=null){
            testMapper.saveUser(user);
        }

    }

    @Override
    public List<User> selectAllUser() {
        return testMapper.selectAllUser();
    }
}
