package com.atguigu.test.day3.practice;

public class Test01 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.name + "," + s.age);
    }
    static class Student { String name; int age; };
    int x = 10;
    static int y = 20;
    public static void test() {
//        System.out.println(x);
        System.out.println(y);
    }
}
