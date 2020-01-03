package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月17日 19:09
 *
 */

import com.hzm.springboot.exection.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException("用户不存在");
        }
        return "hello world";
    }
}
