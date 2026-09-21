package com.atguigu.spring_aop.test;

import com.atguigu.spring_aop.demo01.CalculatorPureImpl;
import com.atguigu.spring_aop.demo01.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class demo01 {
    @Test
    public void test01(){
//        new CalculatorStaticProxy()
        CalculatorPureImpl calculatorPureImpl = new CalculatorPureImpl();
        calculatorPureImpl.add(1,2);
        System.out.println("-------------------------------------");
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculatorPureImpl);
        calculatorStaticProxy.add(1, 2);

    }
}
