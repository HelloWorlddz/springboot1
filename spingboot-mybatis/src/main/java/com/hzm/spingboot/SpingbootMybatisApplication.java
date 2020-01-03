package com.hzm.spingboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.hzm.spingboot.mapper")
@SpringBootApplication
public class SpingbootMybatisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpingbootMybatisApplication.class, args);
    }

}
