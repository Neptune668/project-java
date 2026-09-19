package com.atguigu.demo.test.day4.lambda;

public class Demo1 {
    public static void main(String[] args) {
        SayHello s1 = () -> System.out.println("匿名内部类的实现方式~~~");
        s1.hello();
    }
}
