package com.linkedbear.spring.annotation.a_quickstart.bean;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    private int totalOrders;
    
    public void addOrder() {
        totalOrders++;
        // 计算逻辑...
    }
}

