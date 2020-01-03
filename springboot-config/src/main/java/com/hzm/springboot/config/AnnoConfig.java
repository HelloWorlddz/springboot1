package com.hzm.springboot.config;/*
 *
 *@author hzm
 *@date 2019年08月14日 20:15
 *
 */

import org.springframework.stereotype.Component;

/*springboot 同样会注入此类,即添加组件
id不写，默认是类名（首字母小写）*/
@Component(value = "config")
public class AnnoConfig {
}
