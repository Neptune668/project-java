package com.atguigu.java.day2.base_grammar;

public class Demo11_IfElse {

    public static void main(String[] args) {
        int age = 89;

        if (age < 18) {
            System.out.println("未成年还不能上班~~~");
        } else if (age >= 18 && age < 60) {
            System.out.println("成年可以上班，还不能退休~~~");
        } else {
            System.out.println("老年可以退休~~~");
        }
    }

}
