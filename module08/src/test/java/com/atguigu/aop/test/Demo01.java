package com.atguigu.aop.test;

import com.atguigu.aop.api.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo01 {
    @Autowired
    private Calculator calculator;
    @Test
    public void test01() {
        calculator.add(1, 2);
        System.out.println("------------------------------------------");
        calculator.sub(1, 2);
        System.out.println("------------------------------------------");
        calculator.mul(1, 2);
        System.out.println("------------------------------------------");
        calculator.div(1, 2);
        System.out.println("------------------------------------------");
//        calculator.div(1, 0);
    }
}
