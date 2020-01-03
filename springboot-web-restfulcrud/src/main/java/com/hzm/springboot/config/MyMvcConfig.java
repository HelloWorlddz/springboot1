package com.hzm.springboot.config;/*
 *
 *@author hzm
 *@date 2019年08月15日 15:04
 *
 */
import com.hzm.springboot.component.LoginHandlerInterceptor;
import com.hzm.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展SpringMvc的内容
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //http://localhost:8080/atguigu,跳转到success页面(转发到页面)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送/atgugui 请求来到success视图中，不需要像Controller那样Requestmapper.
        registry.addViewController("/atguigu").setViewName("success");
        //restful crud的首页，来到templates/login.html视图
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态资源；  *.css , *.js
        //SpringBoot 2以上,自定义的拦截器是需要给静态资源放行 静态资源的访问路径为 /asserts/**，或者/webjars/**
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
    }

    //将自定义的MyLocaleResolver的加载到容器中
    @Bean
    public LocaleResolver localeResolver(){

        return new MyLocaleResolver();
    }

}
