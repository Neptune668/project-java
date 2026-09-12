package com.atguigu.java.day1;

public class Demo04_Variable {

    public static void main(String[] args) {
        // 1、声明变量必须指定类型
        int age = 10;
        System.out.println("age = " + age);

        // 2、变量的类型约束会一直存在
        // age = false;

        // 3、读取局部变量前必须初始化
        int count;
        count = 100;
        System.out.println("count = " + count);

        // 4、变量作用域在当前大括号范围内有效
        System.out.println("age = " + age);
        System.out.println("count = " + count);

        // 5、final 修饰的变量只能赋值一次，成为常量
        final int a = 11112222;
        // a = 666;
        System.out.println("a = " + a);

        // 6、for 循环的小括号中声明的变量，仅限在 for 循环内使用
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
        // 循环外不能使用循环变量
        // System.out.println("i = " + i);
    }

    public void doSth() {
        // 当前方法内声明的同名变量和 main 方法中的没有任何关系
        int age = 111;
        int count = 666;
        // age、count 都是在 main 方法中声明的，在另外的方法中不能使用
        System.out.println("age = " + age);
        System.out.println("count = " + count);
    }

}
