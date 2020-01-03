package com.hzm.springboot.config;/*
 *
 *@author hzm
 *@date 2019年08月14日 19:56
 *
 */

import com.hzm.springboot.Service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
springboot推荐给容器中添加组件的方式是使用纯注解的方式
指定当前类是一个配置类，替代之前spring的配置文件
* */
@Configuration
public class MyAppConfig {
    @Bean //将方法的返回值添加到容器中，容器中的这个组件默认的id就是方法名
    public HelloService helloService(){
        System.out.println("给容器中添加组件了...");
        return new HelloService();
    }
}
