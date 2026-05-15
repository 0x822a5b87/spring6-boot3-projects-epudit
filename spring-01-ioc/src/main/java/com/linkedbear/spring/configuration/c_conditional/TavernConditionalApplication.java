package com.linkedbear.spring.configuration.c_conditional;

import com.linkedbear.spring.configuration.c_conditional.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class TavernConditionalApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(ctx.getBeanDefinitionNames())
              .filter(name -> !name.startsWith("org.springframework"))
              .forEach(System.out::println);
    }
}
