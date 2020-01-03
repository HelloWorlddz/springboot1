package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月15日 12:09
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String hello(Map<String,Object>map){
        map.put("hello","123");
        map.put("hzm","<h1>hello</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        //会去classpath:/templates/success.html中
        return "success";
    }
}
