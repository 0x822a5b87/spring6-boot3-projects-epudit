package com.linkedbear.springboot.aop.h_instantiationmodel;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect("perthis(execution(public * example.demo.*.*(..)) || target(example.demo.test.Service3))")
@Scope("prototype")
@Component
public class LogAspect {
    
    public LogAspect() {
        System.out.println("LogAspect constructor run ......");
    }
    
    @Before("execution(public * example.demo.*.*(..)) || execution(public * example.demo.test.Service3.*(..))")
    public void before() {
        System.out.println(this);
        System.out.println("check before invoke ......");
    }
}
