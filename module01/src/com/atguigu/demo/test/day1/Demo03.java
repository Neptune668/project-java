package com.atguigu.demo.test.day1;

public class Demo03{
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);          // true （字符串常量池）
        System.out.println(s1 == s3);          // false （new 出来的新对象）
        System.out.println(s1.equals(s3));     // true （比较内容要用 equals）
    }
}
