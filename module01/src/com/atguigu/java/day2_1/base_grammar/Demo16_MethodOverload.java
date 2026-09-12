package com.atguigu.java.day2_1.base_grammar;

public class Demo16_MethodOverload {

    public static void main(String[] args) {
        // 分别调用三个重载的方法
        System.out.println(mul(5, 10));
        System.out.println(mul(5.0, 10.0));
        System.out.println(mul(5, 10, 10));
    }

    // 针对两个整数做乘法
    public static int mul(int i, int j) {
        System.out.println("针对两个整数做乘法");
        return i * j;
    }

    // 针对两个小数做乘法
    public static double mul(double i, double j) {
        System.out.println("针对两个小数做乘法");
        return i * j;
    }

    // 针对三个整数做乘法
    public static int mul(int i, int j, int k) {
        System.out.println("针对三个整数做乘法");
        return i * j * k;
    }
}
