package com.linkedbear.springboot.ai.f_toolcalling.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration(proxyBeanMethods = false)
public class StoreToolRegistration {
    
    @Bean
    @Description("查询指定商品的库存")
    public Function<String, Integer> getStock() {
        return productId -> {
            return switch (productId) {
                case "1" -> 100;
                case "2" -> 200;
                default -> 0;
            };
        };
    }
}
