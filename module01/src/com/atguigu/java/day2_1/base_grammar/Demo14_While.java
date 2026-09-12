package com.atguigu.java.day2_1.base_grammar;

public class Demo14_While {

    public static void main(String[] args) {
        int age = 100;

        while (age < 18) {
            System.out.println("age = " + age + "，你还未成年！");
            age++;
        }

        System.out.println("恭喜你！终于成年了！！！age = " + age);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        do {
            System.out.println("你还不能退休，继续上班！age = " + age);
            age++;
        } while (age < 60);
    }

}
