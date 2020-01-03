package com.hzm.springboot.model;/*
 *
 *@author hzm
 *@date 2019年08月14日 17:17
 *
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;
/*将配置文件的每一个属性的值，映射到这个组件中
                @ConfigurationProperties springBoot将本类中的所有属性和配置文件中的相关配置进行绑定
                              perfix="person":配置文件下哪个下面的关键字与所有属性进行一一配置
        此外只有这个组件是容器中的组件，才能使用容器中提供的@ConfigurationProperties功能

 一 @ConfigurationProperties(prefix = "person")获取值 默认配置文件在application.yml/propertie里直接配置
    1.必须提供set/get方法，且上面的变量名称与配置文件中的一致
    2.但支持last-name=lastName，松散的语法
    3.批量绑定配置文件中的属性
    4.不支持spel表达式
    5.支持jsr303数据校验(@Validated)
    6.支持复杂封装map
                         */
/*// 二 @Value获取值(默认配置文件在application.yml/propertie里直接配置,同样也需要配置在容器中)
    1一个个绑定
    2.不支持松散绑定语法,即不支持last-name=lastName
    3.属性名称和位置文件中的名称可以不一致
    即 @Value("${person.last-name}")
         private String name;
    4.支持spel写法
    5.不支持jsr303数据校验\
    6.不支持复杂封装map
    如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
    如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
    */

/*三:@PropertySource 加载指定的配置文件
*     1.需要与@ConfigurationProperties(prefix = "person")一起使用
*     2.或者和@Value一起使用
*
* */


@Component
@PropertySource(value = {"classpath:person.properties"})
//@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
    //@Email
    //@Value("${person.lastName}")
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
