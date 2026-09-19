package com.atguigu.demo.test.day3.practice1;

public class Test01 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Banana banana = new Banana();
        banana.setFruitName("香蕉");
        banana.setFruitPrice(10.0);
        banana.showFruitInfo();

        apple.setFruitName("苹果");
        apple.setFruitPrice(20.3);
        apple.showFruitInfo();
    }
}
