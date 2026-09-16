package com.atguigu.java.day2.base_grammar;

public class Demo13_For {

    public static void main(String[] args) {
        // 1、常规用法（快捷方式：fori回车）
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }

        // 2、增强的 for 循环
        // [1]创建一个数组
        int[] nums = {5, 8, 11, 32, 67};

        // [2]使用增强的 for 循环遍历（快捷方式：iter回车）
        for (int n : nums) {
            System.out.println("n = " + n);
        }
    }

}
