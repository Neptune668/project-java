package com.atguigu.proxy.test;

import com.atguigu.proxy.api.Calculator;
import com.atguigu.proxy.impl.CalculatorPureImpl;
import com.atguigu.proxy.proxy.CalculatorStaticProxy;
import com.atguigu.proxy.proxy.LogDynamicProxyFactory;
import org.junit.Test;

public class Demo01 {
    @Test
    public void test01() {
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(calculatorPure);
        proxy.add(10, 8);
    }
    @Test
    public void test02() {
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        Calculator proxy = (Calculator)new LogDynamicProxyFactory(calculatorPure).getProxy();
        proxy.add(10, 8);
    }
}