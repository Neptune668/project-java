package com.atguigu.demo.test.day4.lambda;

public class Demo2 {
    public static void main(String[] args) {
        BuySomething buySomething = money -> "66元买眉笔";
        System.out.println(buySomething.buyItByMoney("66"));
    }
}
