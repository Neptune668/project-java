package com.atguigu.java.day2_1.base_grammar;

public class Demo03_Identifier {

    public static void main(String[] args) {
        // 标识符不能使用非法字符
        // int age@ = 10;

        // 标识符首字母不能是数字
        // int 5age = 10;

        // 测试标识符严格区分大小写
        int age = 10;
        System.out.println("age = " + age);

        int AGE = 18;
        System.out.println("AGE = " + AGE);

        // 不能使用关键字作为标识符
        // int return = 10;

        // 可以使用中文
        int 年龄 = 100;
        System.out.println("年龄 = " + 年龄);

        // 同一个作用域（同一组大括号内）内，不能重复声明变量
        // int age = 888;
        // System.out.println("age = " + age);
    }

}
