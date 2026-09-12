package com.atguigu.java.day1;

public class Demo05_TypeConvert {

    public static void main(String[] args) {
        // 1、小类型转大类型
        int a = 10;
        System.out.println("a = " + a);

        double b = a;
        System.out.println("b = " + b);

        // 2、大类型转小类型
        double m = 10.8;
        int n = (int)m;
        System.out.println("n = " + n);
    }

}
