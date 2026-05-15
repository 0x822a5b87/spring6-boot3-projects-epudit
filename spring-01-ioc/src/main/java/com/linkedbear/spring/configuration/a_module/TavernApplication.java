package com.linkedbear.spring.configuration.a_module;

import com.linkedbear.spring.configuration.a_module.config.TavernConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class TavernApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Object obj = ctx.getBean("com.linkedbear.spring.configuration.a_module.component.Boss", Object.class);

        System.out.println(obj);
        Stream.of(ctx.getBeanDefinitionNames())
              .filter(name -> !name.startsWith("org.springframework"))
              .forEach(System.out::println);
        System.out.println("--------------------------");
    }
}
