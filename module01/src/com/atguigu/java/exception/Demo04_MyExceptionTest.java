package com.atguigu.java.exception;

public class Demo04_MyExceptionTest {

    public static void main(String[] args) {
        throw new UserLoginFailedException("登录失败！用户名不存在或密码错误！");
    }

}
