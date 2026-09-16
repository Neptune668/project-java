package com.atguigu.test.day3.practice1;

public class cat extends Animal{

    public cat(String animalName) {
        super(animalName);
        System.out.println("打印父类的成员变量值：animalName = " + super.getAnimalName());
    }

    public void printCatInfo() {
        System.out.println("[子类]猫信息：" + super.showAnimalInfo());
    }
}
