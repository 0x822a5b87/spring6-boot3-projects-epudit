package com.linkedbear.springboot.aop.i_introduction.validator;

import org.springframework.stereotype.Component;

@Component
public class MoneyValidatorImpl implements MoneyValidator {
    
    @Override
    public boolean validate(int money) {
        return money > 0;
    }
}
