package com.linkedbear.springboot.practice;

import com.linkedbear.springboot.practice.bean.Cat;
import com.linkedbear.springboot.practice.bean.Dog;
import com.linkedbear.springboot.practice.logging.LoggingService;
import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPracticeApplication {

    @Value("${person.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringBootPracticeApplication.class);
        springApplication.setAdditionalProfiles("sky");
        var ctx = springApplication.run(args);

        System.out.println("rabbit是否存在：" + ctx.containsBeanDefinition("rabbit"));
        System.out.println("turtle是否存在：" + ctx.containsBeanDefinition("turtle"));
        System.out.println("fish是否存在：" + ctx.containsBeanDefinition("fish"));
        System.out.println("bird是否存在：" + ctx.containsBeanDefinition("bird"));
        System.out.println("bat是否存在：" + ctx.containsBeanDefinition("bat"));

        var loggingService = ctx.getBean(LoggingService.class);
        loggingService.printLog();
        loggingService.info(ctx.getBean(SpringBootPracticeApplication.class).name.toString());

        ctx.start();
        ctx.stop();
    }
}
