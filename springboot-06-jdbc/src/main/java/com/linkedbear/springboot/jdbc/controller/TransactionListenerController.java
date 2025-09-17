package com.linkedbear.springboot.jdbc.controller;

import com.linkedbear.springboot.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionListenerController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/saveUser")
    public void saveUser() {
        userService.saveUser();
    }
}
