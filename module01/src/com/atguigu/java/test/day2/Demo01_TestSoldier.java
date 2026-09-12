package com.atguigu.java.test.day2;

public class Demo01_TestSoldier {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.name = "许三多";
        soldier.weapon = "八一杠";
        soldier.age = 23;
        soldier.salary = 3333.33;
        System.out.println("在对象中设置属性之后soldier = " + soldier);
    }
}
