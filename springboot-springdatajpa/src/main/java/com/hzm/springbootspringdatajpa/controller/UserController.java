package com.hzm.springbootspringdatajpa.controller;/*
 *
 *@author hzm
 *@date 2019年08月14日 12:39
 *
 */

import com.hzm.springbootspringdatajpa.UserRepository;
import com.hzm.springbootspringdatajpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer sid){
        User user = userRepository.findByJpqlId(sid);
        return user;

    }

    @GetMapping("/user")
    public User insertUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }
}
