package com.linkedbear.springboot.aop;

import com.linkedbear.springboot.aop.l_loganno.service.FinanceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
//@SpringBootApplication(scanBasePackages = {"com.linkedbear.springboot.aop.a_aspectj", "com.linkedbear.springboot.aop.j_methodinterceptor"})
@SpringBootApplication(scanBasePackages = "com.linkedbear.springboot.aop.l_loganno")
public class SpringBootAopApplication {
    
    public static void main(String[] args) {
        var ctx = new SpringApplicationBuilder(SpringBootAopApplication.class).web(WebApplicationType.NONE).run(args);
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//        financeService.addMoney(123.45);
//        financeService.subtractMoney(543.21);
//        financeService.getMoneyById("abc");
        
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//        financeService.addMoney(123.45);
//        financeService.subtractMoney(543.21);
        
//        UserService userService = ctx.getBean(UserService.class);
//        userService.saveUser("abc");
//        FinanceService financeService = ctx.getBean(FinanceService.class);
//        financeService.transfer(1L, 2L, 100);
        
//        ctx.getBean(UserService.class).saveUser("1");
//        ctx.getBean(UserService.class).saveUser("1");
//        ctx.getBean(UserService.class).saveUser("1");
//
//        new Thread(() -> {
//            ctx.getBean(UserService.class).saveUser("1");
//        }).start();
        
//        UserService userService = ctx.getBean(UserService.class);
//        ExtendsUserService extendsUserService = ctx.getBean(ExtendsUserService.class);
//        extendsUserService.saveUser("1");
//        extendsUserService.deleteUser("1");
//        ctx.getBean(IService.class).add();
//        ctx.getBean(IService.class).add();
//        System.out.println();
//
//        ctx.getBean(Service2.class).add();
//        ctx.getBean(Service2.class).add();
//        System.out.println();
//
//        ctx.getBean(Service3.class).add();
//        ctx.getBean(Service3.class).add();
//        System.out.println();
//        ctx.getBean(Service4.class).add();
//        ctx.getBean(Service4.class).add();
//        ctx.getBean(FinanceService.class).transfer(1L, 2L, 100);
//        ctx.getBean(FinanceService.class).transfer(1L, 2L, -1);
        
//        ctx.getBean(FinanceService.class).getMoneyById("1");
        ctx.getBean(FinanceService.class).addMoney("1", 100.00);
    
    }
}
