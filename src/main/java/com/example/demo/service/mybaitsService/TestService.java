package com.example.demo.service.mybaitsService;

import com.example.demo.dataobject.mybaitsTable.User;

import java.util.List;

public interface TestService {
    void saveUser(User user);
    List<User> selectAllUser();
}
