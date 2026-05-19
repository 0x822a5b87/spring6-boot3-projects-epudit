package com.linkedbear.springboot.aop.m_proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    
    @Before("execution(* com.linkedbear.springboot.aop.m_proxy.UserService.*(..))")
    public void before() {
        System.out.println("Before UserService.");
    }
}
