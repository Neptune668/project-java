package com.atguigu.demo.test.day4.generic;

//import com.atguigu.java.day4.generic.Noodle;

public class Demo01 {
    public static void main(String[] args) {
        //测试泛型类
        Bowl<Rice> bowlBowl = new Bowl<>(new Rice());
        bowlBowl.contain(new Rice());
        System.out.println(bowlBowl.foodTool(new Chopsticks()));
    }
}
