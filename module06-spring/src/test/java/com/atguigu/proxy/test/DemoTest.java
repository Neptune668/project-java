package com.atguigu.proxy.test;

import com.atguigu.proxy.api.Calculator;
import com.atguigu.proxy.api.SoldierService;
import com.atguigu.proxy.impl.CalculatorPureImpl;
import com.atguigu.proxy.impl.SoldierServiceImpl;
import com.atguigu.proxy.proxy.CalculatorStaticProxy;
import com.atguigu.proxy.proxy.LogDynamicProxyFactory;
import org.junit.Test;

public class DemoTest {

    @Test
    public void test01() {
        // 测试静态代理
        // 1、创建被代理的目标对象
        Calculator target = new CalculatorPureImpl();

        // 2、创建代理对象
        Calculator proxy = new CalculatorStaticProxy(target);

        // 3、通过代理对象调用目标对象的方法
        proxy.add(10, 8);
        System.out.println("----------------------");
        proxy.sub(10, 8);
        System.out.println("----------------------");
        proxy.mul(10, 8);
        System.out.println("----------------------");
        proxy.div(10, 8);
    }

    @Test
    public void test02() {
        // 测试动态代理
        // 1、创建被代理的目标对象
        Calculator target = new CalculatorPureImpl();

        // 2、创建代理对象
        Calculator proxy = new LogDynamicProxyFactory<>(target).getProxy();

        // 3、通过代理对象调用目标方法
        proxy.add(10, 8);
        System.out.println("----------------------");
        proxy.sub(10, 8);
        System.out.println("----------------------");
        proxy.mul(10, 8);
        System.out.println("----------------------");
        proxy.div(10, 0);
    }

    @Test
    public void test03() {
        // 测试动态代理：往不同的目标上套，代理工厂的代码不需要做任何修改
        // 1、创建被代理的目标对象
        SoldierService target = new SoldierServiceImpl();

        // 2、创建代理对象
        SoldierService proxy = new LogDynamicProxyFactory<>(target).getProxy();

        // 3、通过代理对象调用目标对象的方法
        proxy.saveSoldier();
        System.out.println("----------------------");
        proxy.removeSoldier();
        System.out.println("----------------------");
        proxy.updateSoldier();
        System.out.println("----------------------");
        proxy.querySoldier();
    }
}
