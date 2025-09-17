package com.linkedbear.springboot.aop.k_proxyfactory;

import com.linkedbear.springboot.aop.a_aspectj.service.FinanceService;
import com.linkedbear.springboot.aop.j_methodinterceptor.PerformanceMethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class ProxyFactoryApplication {
    
    public static void main(String[] args) {
        
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new FinanceService());
        proxyFactory.setProxyTargetClass(true);
        // 只针对getMoneyById方法增强
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setPointcut(new NameMatchMethodPointcut().addMethodName("getMoneyById"));
        pointcutAdvisor.setAdvice(new PerformanceMethodInterceptor());
        proxyFactory.addAdvisor(pointcutAdvisor);
        // 对所有方法都增强
        proxyFactory.addAdvice(new PerformanceMethodInterceptor());
        FinanceService financeService = (FinanceService) proxyFactory.getProxy();
        financeService.addMoney(1.00);
        financeService.getMoneyById("1");
    }
}
