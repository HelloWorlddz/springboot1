package com.hzm.springboot.config;/*
 *
 *@author hzm
 *@date 2019年08月14日 9:41
 *
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){

        return new DruidDataSource();
    }
    ///配置Druid的监控页面
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //1.页面访问地址，servletRegistrationBean,注册自己写的方法和路径
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
        //2 设置用户名和密码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","hzm");
        //3 默认就是允许所有访问
        initParams.put("allow","localhost");//如果为null 或者为"",表示允许所有人访问
        bean.setInitParameters(initParams);
        return  bean;
    }

    //2、配置一个web监控的filter
    //webStatFilter:用于配置web和druid数据源之间的管理关联监控统计
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //exclusion:设置哪些请求进行过滤掉，从而不进行统计
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        //"/*"表示过滤所有的请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }


}
