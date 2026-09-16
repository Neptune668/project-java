package com.atguigu.java.day5.other;

public class Demo05_Math {

    public static void main(String[] args) {
        System.out.println("-10 的绝对值" + Math.abs(-10));
        System.out.println("4 的平方：" + Math.pow(4, 2));
        System.out.println("16 的平方根：" + Math.sqrt(16));
        System.out.println("3 和 6 中的最大值：" + Math.max(3, 6));
        for (int i = 0; i < 10; i++) {
            System.out.println("随机数：" + Math.random());
        }
    }

}
