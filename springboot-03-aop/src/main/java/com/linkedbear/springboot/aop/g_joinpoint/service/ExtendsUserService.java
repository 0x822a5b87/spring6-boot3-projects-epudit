package com.linkedbear.springboot.aop.g_joinpoint.service;

import com.linkedbear.springboot.aop.g_joinpoint.annotation.Print;
import org.springframework.stereotype.Service;

//@Print
@Service
public class ExtendsUserService extends UserService {
    
    public void deleteUser(String id) {
        System.out.println("ExtendsUserService 删除用户：" + id);
    }
}
