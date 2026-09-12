package com.atguigu.java.day2_1.base_grammar;

public class Demo06_StringCompare {

    public static void main(String[] args) {
        // 1、基于常量池创建字符串，指向常量池中的同一块空间
        String str01 = "apple";
        String str02 = "apple";

        // 2、手动创建字符串对象，指向堆内存里的另外一块空间
        String str03 = new String("apple");

        // 3、字符串比较
        System.out.println(str01 == str02); // true
        System.out.println(str01 == str03); // false
        System.out.println(str01.equals(str03)); // 比较字符串内容，true
    }

}
