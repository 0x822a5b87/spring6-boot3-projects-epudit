package com.linkedbear.springboot.aop.l_loganno.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Logger(type = Logger.LogType.FILE)
public @interface FinanceLogger {
    
    @AliasFor(annotation = Logger.class)
    String value();
}
