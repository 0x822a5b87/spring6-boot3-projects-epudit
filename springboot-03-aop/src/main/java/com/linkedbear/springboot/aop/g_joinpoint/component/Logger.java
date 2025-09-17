package com.linkedbear.springboot.aop.g_joinpoint.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    
//    @Before("execution(* com.linkedbear.springboot.aop.g_joinpoint..*.addMoney(*))")
//    @Before("args(double) && execution(* com.linkedbear.springboot.aop.g_joinpoint..*(..))")
//    @Before("args(String, double) && execution(* com.linkedbear.springboot.aop.g_joinpoint..*(..))")
//    @Before("@args(com.linkedbear.springboot.aop.g_joinpoint.annotation.Log)")
//    @Before("within(com.linkedbear.springboot.aop.g_joinpoint.service.FinanceService)")
//    @Before("within(com.linkedbear.springboot.aop.g_joinpoint..*)")
//    @Before("@within(com.linkedbear.springboot.aop.g_joinpoint.annotation.Print)")
//    @Before("target(com.linkedbear.springboot.aop.g_joinpoint.service.UserService)")
//    @Before("@target(com.linkedbear.springboot.aop.g_joinpoint.annotation.Print) && execution(* com.linkedbear.springboot.aop.g_joinpoint..*(..))")
//    @Before("bean(*Service)")
    public void beforePrint(JoinPoint joinPoint) {
        System.out.println("Logger beforePrint run ......");
    }
    
}