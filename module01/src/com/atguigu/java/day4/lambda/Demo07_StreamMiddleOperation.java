package com.atguigu.java.day4.lambda;

import java.util.Arrays;

public class Demo07_StreamMiddleOperation {

    public static void main(String[] args) {
        String[] nameArr = {"Tom", "Jerry", "Harry", "Harry", "Bob", "Bob", "Kate", "Mary"};

        // filter() 传入一个断言型函数式接口的 Lambda 表达式
        // Lambda 体中返回 true 对应的元素就保留；返回 false 对应的元素就被剔除
        Arrays.stream(nameArr)
                .filter(name -> name.length() >= 4)
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        // map() 传入一个函数型的函数式接口的 Lambda 表达式
        // Lambda 体中执行针对传入的每一个元素的处理操作
        Arrays.stream(nameArr)
                .map(name -> name + "@")
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        // 基于 Comparator 接口提供排序依据或不传参数使用自然排序
        Arrays.stream(nameArr)
                .sorted((n1, n2) -> n1.length() - n2.length()) // sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        System.out.println("--------------------------------");

        Arrays.stream(nameArr)
                .distinct() // 去重
                .skip(3) // 跳过开头的前几个元素
                .limit(3) // 保留开头的前几个元素
                .forEach(System.out::println);
    }

}
