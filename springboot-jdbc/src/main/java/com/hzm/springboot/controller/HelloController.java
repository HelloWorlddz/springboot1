package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月13日 22:43
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/query")
    public Map<String,Object> query(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList(" select * from department");
        return list.get(0);
    }

}
