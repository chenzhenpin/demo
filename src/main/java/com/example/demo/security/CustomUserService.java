package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user=sysUserRepository.findByUsername(username);
        System.out.println("账号："+username);
        if (user==null){
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
