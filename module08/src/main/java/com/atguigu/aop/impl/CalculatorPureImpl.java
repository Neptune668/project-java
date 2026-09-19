package com.atguigu.aop.impl;
    
//import com.atguigu.aop.annotation.PrintLogAnnotation;
import com.atguigu.aop.api.Calculator;
import org.springframework.stereotype.Component;

// 被代理的目标类，必须放入 IoC 容器才能起作用
@Component
public class CalculatorPureImpl implements Calculator {
    
    @Override
    public int add(int i, int j) {
    
        int result = i + j;
    
        System.out.println("方法内部 result = " + result);
    
        return result;
    }

//    @PrintLogAnnotation(info = "减法设置了自定义注解，噢耶！~~~")
    @Override
    public int sub(int i, int j) {
    
        int result = i - j;
    
        System.out.println("方法内部 result = " + result);
    
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        System.out.println("方法内部 result = " + result);
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        System.out.println("方法内部 result = " + result);
    
        return result;
    }
}