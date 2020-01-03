package com.hzm.springboot;/*
 *
 *@author hzm
 *@date 2019年08月13日 18:09
 *
 */

public class HelloService {
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
    public String sayHello(String name){
        return helloProperties.getPrefix()+"--"+name+helloProperties.getSuffix();
    }
}
