package com.linkedbear.springboot.routedatasource.controller;

import com.linkedbear.springboot.routedatasource.datasource.RouteDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/test1")
    public Object test1() {
        return jdbcTemplate.queryForList("select * from tbl_user").get(0);
    }
    
    @GetMapping("/test2")
    public Object test2() {
        RouteDataSource.set("slave");
        return jdbcTemplate.queryForList("select * from tbl_user").get(0);
    }
}
