package com.hzm.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//
//默认springboot不会识别我们写的bean.xml，想让spring的配置文件生效，需要在一个配置类上加上@ImportSource
@SpringBootApplication
@ImportResource(value = {"classpath:bean.xml"})
public class SpringbootConfigApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootConfigApplication.class, args);
    }
}
