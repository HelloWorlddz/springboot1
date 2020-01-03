package com.hzm.springboot;/*
 *
 *@author hzm
 *@date 2019年08月13日 18:06
 *
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hzm.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
