package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月16日 22:18
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    @GetMapping("/abc")
    public String success(Model model){
        model.addAttribute("msg","你好！！！");
        return "success";
    }
}
