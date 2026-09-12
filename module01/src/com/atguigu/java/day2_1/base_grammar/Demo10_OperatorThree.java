package com.atguigu.java.day2_1.base_grammar;

public class Demo10_OperatorThree {

    public static void main(String[] args) {
        int age = 20;

        // 使用三目运算符进行判断：年龄大于等于 18 返回成年；年龄小于 18 返回未成年
        System.out.println(age >= 18 ? "成年" : "未成年");
    }

}
