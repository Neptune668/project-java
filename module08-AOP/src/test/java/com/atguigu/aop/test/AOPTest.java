package com.atguigu.aop.test;

import com.atguigu.aop.api.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void test01() {
        calculator.add(100, 20);
        System.out.println("---------------------------");

        calculator.sub(100, 20);
        System.out.println("---------------------------");

        calculator.mul(100, 20);
        System.out.println("---------------------------");

        calculator.div(100, 0);
    }

}
