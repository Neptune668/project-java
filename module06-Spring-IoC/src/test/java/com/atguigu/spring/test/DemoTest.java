package com.atguigu.spring.test;

import com.atguigu.spring.controller.AppleController;
import com.atguigu.spring.demo.CarFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// 通过 @SpringBootTest 注解能够把 SpringBoot 和 Junit 整合到一起
@SpringBootTest
public class DemoTest {

    // 用 @SpringBootTest 注解把 SpringBoot 和 Junit 整合到一起，就有下面福利：
    // 福利：IoC 中的 bean 可以直接用 @Autowired 注解装配进来
    @Autowired
    private AppleController appleController;

    @Autowired
    private CarFactory carFactory;

    @Value("${atguigu.config.info}")
    private String atguiguConfigInfo;

    @Value("${spring.application.name}")
    private String appName;

    @Test
    public void test01() {
        System.out.println("sss...");
    }

    @Test
    public void test02() {
        String hello = appleController.hello();
        System.out.println("hello = " + hello);
    }

    @Test
    public void test03() {
        System.out.println(carFactory);
    }

    @Test
    public void test04() {
        System.out.println("atguiguConfigInfo = " + atguiguConfigInfo);
    }

    @Test
    public void test05() {
        System.out.println("appName = " + appName);
    }
}
