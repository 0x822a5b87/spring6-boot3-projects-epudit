package com.linkedbear.springboot.aop.l_loganno.config;

import com.linkedbear.springboot.aop.l_loganno.annotation.Logger;
import com.linkedbear.springboot.aop.l_loganno.aspect.LoggerMethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;

@Configuration(proxyBeanMethods = false)
public class LoggerConfiguration {
    
    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public Advisor loggerAdvisor() {
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, Logger.class, true);
        LoggerMethodInterceptor loggerMethodInterceptor = new LoggerMethodInterceptor();
        return new DefaultPointcutAdvisor(pointcut, loggerMethodInterceptor);
    }
}
