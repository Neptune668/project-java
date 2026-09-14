package com.atguigu.java.day3;

public class Animal {

    protected String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public String showAnimalInfo() {
        return "动物名称是：" + this.animalName;
    }
}
