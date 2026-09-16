package com.atguigu.java.day5;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class Demo00_Junit {

    @BeforeEach
    public void init() {
        System.out.println("每次 @Test 注解标记的测试方法执行前，都会执行一次");
    }

    @Test
    public void test01() {
        System.out.println("Hello World Junit ...");
    }

}
