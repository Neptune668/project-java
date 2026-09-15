package com.atguigu.java.day4.exception;

import com.atguigu.java.exception.UserLoginFailedException;

public class Demo04_MyExceptionTest {

    public static void main(String[] args) {
        throw new UserLoginFailedException("登录失败！用户名不存在或密码错误！");
    }

}
