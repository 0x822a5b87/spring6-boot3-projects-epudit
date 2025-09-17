package com.linkedbear.springboot.aop.l_loganno.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Logger {
    
    // 写入日志的内容
    String value() default "";
    
    // 写入日志的载体
    LogType type();
    
    static enum LogType {
        DATABASE, FILE
    }
}
