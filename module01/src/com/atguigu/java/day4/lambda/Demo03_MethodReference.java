package com.atguigu.java.day4.lambda;

public class Demo03_MethodReference {

    public static void main(String[] args) {
        // Lambda 表达式的写法
        HaveBreakfast haveBreakfast = n -> System.out.println(n);
        haveBreakfast.breakfast("小明");

        // Lambda 体如果只有一行代码而且是对方法的调用，那么就可以简化成方法引用
        haveBreakfast = System.out::println;
        haveBreakfast.breakfast("小王");
    }

}
