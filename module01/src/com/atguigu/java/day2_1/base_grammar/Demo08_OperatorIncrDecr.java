package com.atguigu.java.day2_1.base_grammar;

public class Demo08_OperatorIncrDecr {

    public static void main(String[] args) {
        int age = 10;

        // 自增 1 的操作
        age++; // age = age + 1;
        System.out.println("age = " + age);

        // 自减 1 的操作
        age--; // age = age -1;
        System.out.println("age = " + age);

        // ++ 写在后面：先取值，后++
        System.out.println("age = " + (age++)); // 10
        System.out.println("age = " + age); // 11

        // ++ 写在前面：先++，后取值
        System.out.println("age = " + (++age)); // 12

        // 经常用于循环变量的累加
        // for(int i = 0; i < 10; i++) {
        //
        // }
    }

}
