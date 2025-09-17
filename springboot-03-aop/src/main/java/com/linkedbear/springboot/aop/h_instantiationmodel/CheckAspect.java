package com.linkedbear.springboot.aop.h_instantiationmodel;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckAspect {
    
    public CheckAspect() {
        System.out.println("CheckAspect constructor run ......");
    }
    
    @Before("execution(public * example.demo.test.*.*(..))")
    public void before() {
        System.out.println(this);
        System.out.println("check before invoke ......");
    }
}
