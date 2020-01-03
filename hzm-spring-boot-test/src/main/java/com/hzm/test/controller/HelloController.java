package com.hzm.test.controller;/*
 *
 *@author hzm
 *@date 2019年08月13日 20:38
 *
 */

import com.hzm.springboot.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    //@RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello("test");
    }
}
