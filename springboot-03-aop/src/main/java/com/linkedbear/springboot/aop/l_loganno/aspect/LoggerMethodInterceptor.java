package com.linkedbear.springboot.aop.l_loganno.aspect;

import com.linkedbear.springboot.aop.l_loganno.annotation.Logger;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

public class LoggerMethodInterceptor implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retval = invocation.proceed();
        Method method = invocation.getMethod();
        Logger logger = AnnotationUtils.getAnnotation(method, Logger.class);
        AnnotationAttributes attrs = AnnotatedElementUtils.getMergedAnnotationAttributes(method, Logger.class);
        Enum<?> en = attrs.getEnum("type");
        if (Logger.LogType.FILE.equals(en)) {
            System.out.println("LoggerMethodInterceptor 执行日志文件的写入 === " + attrs.getString("value"));
        } else if (Logger.LogType.DATABASE.equals(en)) {
            System.out.println("LoggerMethodInterceptor 执行数据库日志写入 === " + attrs.getString("value"));
        } else {
            throw new RuntimeException("意外的日志类型");
        }
        return retval;
    }
}
