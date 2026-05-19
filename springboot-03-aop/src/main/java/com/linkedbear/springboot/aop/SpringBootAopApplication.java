package com.linkedbear.springboot.aop;

import com.linkedbear.springboot.aop.m_proxy.UserService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication(scanBasePackageClasses = UserService.class)
public class SpringBootAopApplication {
    
    public static void main(String[] args) {
        System.setProperty("cglib.debugLocation", "./.cglib_classes");
        var ctx = new SpringApplicationBuilder(SpringBootAopApplication.class).web(WebApplicationType.NONE).run(args);
        UserService userService = ctx.getBean(UserService.class);
        userService.add();
    }
}
