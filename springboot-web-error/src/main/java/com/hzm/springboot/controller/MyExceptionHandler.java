package com.hzm.springboot.controller;/*
 *
 *@author hzm
 *@date 2019年08月17日 19:39
 *
 */

import com.hzm.springboot.exection.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //1.ExceptionHandler捕获到的异常,然后以json格式输出,是我们写入的定制数据
    /*
         map.put("code","user.notexist");
         map.put("message",e.getMessage());
    * 没有自适应的效果,浏览器格式的输入和其他客户端格式返回的都是json的数据,而且只有我们的定制数据，没有springboot为我们共享的错误相关数据
    * 不会来到templates/error/xxx.html页面，直接@ResponseBody输出json数据
    * */
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

      /*2能进行自适应效果展示，展示的数据是我们定制的数据和系统boot提供的共享数据，都可以放在templates/error/5xx.html下去取
      ,可以定义一个自己的errorAttributes继承DefaultErrorAttributes，然后将其注入到容器中，在config包下
      将request.setAttribute("ext",map)存入域中,请求转发到springboot默认的/error处理请求，然后自定义的MyErrorAttributes
      会将其存起来，如果我们是浏览器的格式，那么将会从templates/error/5xx.html中取出数据,如果是其他客户端，则会转为json的格式*/
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message","出错了");
        //传入我们自己的错误状态码，4xx,5xx,否则就不会进入错误页面的解析效果,这样就直接来到templates/error/5xx.html页面
        request.setAttribute("javax.servlet.error.status_code",500);
        //转发到/error 由系统的BaseErrorController为我们处理自适应的效果
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
