package com.atguigu.demo.test.day3.test1;

public class Test01 {
    public static void main(String[] args) {
        Shape s = new Circle(2);
        System.out.println(s.area());
        Shape s1 = new Rectangle(10,20);
        System.out.println(s1.area());
    }
}
