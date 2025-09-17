package com.linkedbear.springboot.aop.i_introduction;

import com.linkedbear.springboot.aop.i_introduction.validator.MoneyValidator;
import com.linkedbear.springboot.aop.i_introduction.validator.MoneyValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {
    
    @DeclareParents(value = "com.linkedbear.springboot.aop.i_introduction.FinanceService",
                    defaultImpl = MoneyValidatorImpl.class)
    private MoneyValidator moneyValidator;
    
    /*
    @Before("target(com.linkedbear.springboot.aop.i_introduction.FinanceService)")
    public void beforePrintLog() {
        System.out.println("转账动作前置打印 。。。");
    }
     */
    
    @Before("target(com.linkedbear.springboot.aop.i_introduction.FinanceService)")
    public void beforePrintLog(JoinPoint joinPoint) {
        int money = (int) joinPoint.getArgs()[2];
        MoneyValidator validator = (MoneyValidator) joinPoint.getThis();
        if (validator.validate(money)) {
            System.out.println("转账动作前置打印 。。。");
        } else {
            throw new IllegalArgumentException("转账金额不合法！");
        }
    }
}
