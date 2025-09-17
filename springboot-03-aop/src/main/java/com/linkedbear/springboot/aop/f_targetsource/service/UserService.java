package com.linkedbear.springboot.aop.f_targetsource.service;

import org.springframework.stereotype.Service;

@Service("%userService")
public class UserService {
    
    public UserService() {
        System.out.println("UserService constructor run ......");
    }
    
    public void saveUser(String id) {
        System.out.println("UserService 保存用户" + id);
    }
}
