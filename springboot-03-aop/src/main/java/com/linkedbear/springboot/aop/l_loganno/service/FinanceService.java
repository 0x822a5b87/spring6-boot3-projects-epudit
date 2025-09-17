package com.linkedbear.springboot.aop.l_loganno.service;

import com.linkedbear.springboot.aop.l_loganno.annotation.FinanceLogger;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
    
    @FinanceLogger("发起转账")
    public void addMoney(String id, Double money) {
        System.out.println("为 " + id + " 转钱" + money + "元");
    }
}
