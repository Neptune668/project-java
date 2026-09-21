package com.atguigu.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo03 {
    @Value("${a}")
    private int a;
    @Value("${spring.datasource.url}")
    private String b;
    @Test
    public void test01(){
        System.out.println(a);
        System.out.println("b = " + b);
    }
}
