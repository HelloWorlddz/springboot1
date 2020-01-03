package com.hzm.springboot;

import com.hzm.springboot.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

    @Autowired
    Person person;

    //springboot底层使用slf4j和logback的日志纪录
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
//日志的级别从低到高：trace<debug<info<warn<error
        //可以调整输出的日志级别，日志只会在这个级别之后的高级别生效
      logger.trace("这是trace日志");
      logger.debug("这是debug日志");
      //springBoot默认是给我们设置的输出级别是info级别以上
      logger.info("这是info日志");
      logger.warn("这是warn日志");
      logger.error("这是error日志");




        System.out.println(person);
    }

    @Autowired
    ApplicationContext ioc;


    @Test
    public void testHelloService(){
        //纯注解@Configuration+@Bean 给容器中添加组件
        boolean b1=ioc.containsBean("helloService");
        //在类上声明@Compoment注解，springboot也会给容器中注入组件
        boolean b2 = ioc.containsBean("config");

        boolean b4 = ioc.containsBean("myAppConfig");
      /* 在resources中配置bean.xml 纯xml配置，默认springboot不会识别我们写的bean.xml，
           要想注入到容器中，需要在任一配置类标注了@Configuration的类
          或者@SpringBootApplication主配置类中加入@ImportSource注解即可。
      * */
        boolean b3 = ioc.containsBean("xmlService");
        //Person类上的@Compoment
        boolean b5 = ioc.containsBean("person");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
    }
}
