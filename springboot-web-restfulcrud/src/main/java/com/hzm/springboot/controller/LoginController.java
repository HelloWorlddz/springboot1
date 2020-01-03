package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月15日 20:48
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    @PostMapping (value = "/user/login") //login.html中的请求的method必须是post
    public String login(@RequestParam("username") String name,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(name) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", name);
            return "redirect:/main.html";
        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
