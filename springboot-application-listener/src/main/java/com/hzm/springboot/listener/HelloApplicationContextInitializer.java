package com.hzm.springboot.listener;/*
 *
 *@author hzm
 *@date 2019年08月13日 21:09
 *
 */

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer...initializer"+configurableApplicationContext);
    }
}
