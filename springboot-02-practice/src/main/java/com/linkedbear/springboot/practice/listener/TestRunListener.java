package com.linkedbear.springboot.practice.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

public class TestRunListener implements SpringApplicationRunListener {
    
//    public TestRunListener(SpringApplication springApplication, String[] args) {
//
//    }
    
    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext,
            ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared : " + bootstrapContext);
        System.out.println("environmentPrepared : " + environment);
    }
    
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded : " + context);
    }
    
    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("started : " + context);
        System.out.println(timeTaken);
    }
    
    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("ready : " + context);
        System.out.println(timeTaken);
    }
    
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed : " + context);
        exception.printStackTrace();
    }
}
