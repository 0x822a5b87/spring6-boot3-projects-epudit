package com.linkedbear.springboot.aop.l_loganno.aspect;

import com.linkedbear.springboot.aop.l_loganno.annotation.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggerAspect {
    
    @After("@annotation(com.linkedbear.springboot.aop.l_loganno.annotation.Logger)")
    public void writeLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logger logger = AnnotationUtils.getAnnotation(method, Logger.class);
        // 使用AnnotationUtils获取目标方法上@Logger注解的所有属性值
        AnnotationAttributes attrs = AnnotatedElementUtils.getMergedAnnotationAttributes(method, Logger.class);
        Enum<?> en = attrs.getEnum("type");
        if (Logger.LogType.FILE.equals(en)) {
            System.out.println("LogAspect 执行日志文件的写入 === " + attrs.getString("value"));
        } else if (Logger.LogType.DATABASE.equals(en)) {
            System.out.println("LogAspect 执行数据库日志写入 === " + attrs.getString("value"));
        } else {
            throw new RuntimeException("意外的日志类型");
        }
    }
}
