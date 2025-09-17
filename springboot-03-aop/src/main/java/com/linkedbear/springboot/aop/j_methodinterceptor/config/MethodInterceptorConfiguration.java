package com.linkedbear.springboot.aop.j_methodinterceptor.config;

import com.linkedbear.springboot.aop.j_methodinterceptor.PerformanceMethodInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodInterceptorConfiguration {
    
    @Bean
    public NameMatchMethodPointcut getMoneyByIdPointcut() {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("getMoneyById");
        return pointcut;
    }
    
    @Bean
    public DefaultPointcutAdvisor getMoneyByIdAdvisor(PerformanceMethodInterceptor interceptor) {
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setPointcut(getMoneyByIdPointcut());
        pointcutAdvisor.setAdvice(interceptor);
        return pointcutAdvisor;
    }
}
