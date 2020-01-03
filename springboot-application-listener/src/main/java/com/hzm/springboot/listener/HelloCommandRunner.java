package com.hzm.springboot.listener;/*
 *
 *@author hzm
 *@date 2019年08月13日 21:14
 *
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class HelloCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandRunner..run.."+ Arrays.asList(args));
    }
}
