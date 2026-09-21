package com.atguigu.spring.test;

import com.atguigu.spring.demo2.controller.EmpController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Demo02 {
    @Autowired
    EmpController controller;
    @Test
    public void test01(){
        System.out.println("controller.hello() = " + controller.hello());
    }
}
