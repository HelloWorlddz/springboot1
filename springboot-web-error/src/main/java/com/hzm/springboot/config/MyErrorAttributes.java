package com.hzm.springboot.config;/*
 *
 *@author hzm
 *@date 2019年08月17日 20:27
 *
 */

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回值的map就是页面和json能获取的所有字段,浏览器页面最后是在templates/error/xxx.html页面显示
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //得到共享的一些集合数据
        Map<String,Object> map= super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","hzm");
        //我们的异常处理器携带的数据getAttribute的第二个参数，表示从哪个域中取值，0 代表request域，1 代表session域
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }
}
