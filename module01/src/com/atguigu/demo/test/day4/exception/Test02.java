package com.atguigu.demo.test.day4.exception;

public class Test02 {
    public static void main(String[] args) {
        MyHandler<String> m1 = s -> System.out.println(s);
        m1.handle("Hello World");
        MyHandler<Integer> m2 = (Integer i) -> {
            System.out.println("【处理整数】内容为: " + i + "，平方为: " + (i * i));
        };
        m2.handle(10);
    }
}
