package com.linkedbear.springboot.practice.runner;

import com.linkedbear.springboot.practice.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationRunner implements ApplicationRunner {
    
    private final Person person;

    @Autowired
    public TestApplicationRunner(Person person) {
        this.person = person;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("TestApplicationRunner run ......");
        System.out.println(person);
    }
}
