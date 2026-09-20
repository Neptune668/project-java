package com.atguigu.demo.test;

import com.atguigu.demo.demo04.controller.EmpController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTest {
    @Test
    public void test01() {
        // 单元测试的方法
        System.out.println("appName = " + appName);
        System.out.println("atguiguMessage = " + atguiguMessage);
    }
    @Autowired
    private EmpController empController;
    @Value("${spring.application.name}")
    private String appName;//atguigu.happy.message
    @Value("${atguigu.happy.message}")
    private String atguiguMessage;
    @Test
    public void test02() {
        String hello = empController.hello();
        System.out.println(hello);
    }
}

