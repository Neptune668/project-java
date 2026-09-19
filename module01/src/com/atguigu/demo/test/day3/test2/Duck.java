package com.atguigu.demo.test.day3.test2;

public class Duck implements Flyable, Swimmable{

    @Override
    public void fly() {
        System.out.println("鸭子会飞");
    }

    @Override
    public void swim() {
        System.out.println("鸭子会游泳");
    }
}