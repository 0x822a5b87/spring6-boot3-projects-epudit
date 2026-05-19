package com.linkedbear.springboot.aop.m_proxy;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void get() {
        System.out.println("UserService.get().");
    }

    public void add() {
        ((UserService) AopContext.currentProxy()).get();
        System.out.println("UserService.add().");
    }
}
