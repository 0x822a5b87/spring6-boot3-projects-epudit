package com.linkedbear.spring.bean.a_type;

import com.linkedbear.spring.bean.a_type.bean.Child;
import com.linkedbear.spring.bean.a_type.bean.Toy;
import com.linkedbear.spring.bean.a_type.bean.ToyFactoryBean;
import com.linkedbear.spring.bean.a_type.config.BeanTypeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class BeanTypeAnnoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanTypeConfiguration.class);

        Map<String, Toy> toys = ctx.getBeansOfType(Toy.class);
        System.out.println(toys);

        Toy ball = ctx.getBean("ball", Toy.class);
        Toy toyFactory = ctx.getBean("toyFactory", Toy.class);
        System.out.println(ball);
        System.out.println(toyFactory);

        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//
//        Toy toy1 = ctx.getBean(Toy.class);
//        Toy toy2 = ctx.getBean(Toy.class);
//        System.out.println(toy1 == toy2);
//
//        ToyFactoryBean factoryBean = ctx.getBean(ToyFactoryBean.class);
//        System.out.println(factoryBean);
//        System.out.println(ctx.getBean("toyFactory"));
//        System.out.println(ctx.getBean("&toyFactory"));
//
//        System.out.println(factoryBean.getChild());
//
//        Child child1 = ctx.getBean(Child.class);
//        System.out.println(child1);
//        Child child2 = ctx.getBean(Child.class);
//        System.out.println(child2);
//        System.out.println(child1 == child2);
    }
}
