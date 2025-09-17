package com.linkedbear.springboot.aop.g_joinpoint.service;

import com.linkedbear.springboot.aop.g_joinpoint.annotation.Log;
import com.linkedbear.springboot.aop.g_joinpoint.annotation.Print;
import com.linkedbear.springboot.aop.g_joinpoint.entity.User;
import org.springframework.stereotype.Service;

@Log
@Print
@Service
public class UserService {
    
    public void saveUser(String id) {
        System.out.println("UserService 保存用户" + id);
    }
    
    public void saveUser(User user) {
        System.out.println("UserService 保存用户对象：" + user);
    }
}
