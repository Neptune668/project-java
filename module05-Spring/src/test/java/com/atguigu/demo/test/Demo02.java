package com.atguigu.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.beans.factory.annotation.Value;


@SpringBootTest
public class Demo02 {
    @Value("${atguigu.happy.message}")
    private String atguiguMessage;
    @Value("${spring.application.name}")
    private String appName;

    @Test
    public void test04() {
        System.out.println("atguiguConfigInfo = " + atguiguMessage);
    }

    @Test
    public void test03(){
        System.out.println("appName = " + appName);
    }
}