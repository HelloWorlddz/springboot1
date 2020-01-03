package com.hzm.springboot.exection;/*
 *
 *@author hzm
 *@date 2019年08月17日 19:08
 *
 */

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String msg){
        super(msg);
    }
}
