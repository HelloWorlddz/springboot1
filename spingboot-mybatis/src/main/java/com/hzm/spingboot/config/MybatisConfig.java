package com.hzm.spingboot.config;/*
 *
 *@author hzm
 *@date 2019年08月14日 14:25
 *
 */

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class MybatisConfig {

*//*法一：设置驼峰表与模型的命名规则*//*
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}*/
