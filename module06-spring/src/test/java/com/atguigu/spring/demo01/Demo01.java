package com.atguigu.spring.demo01;

import org.junit.jupiter.api.Test;

public class Demo01 {
    @Test
    public void test01() {
        Calculator calculator = new CalculatorLogImpl();
        int result = calculator.add(1, 2);
        System.out.println("result = " + result);
    }
}
