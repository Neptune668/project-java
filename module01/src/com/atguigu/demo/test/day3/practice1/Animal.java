package com.atguigu.demo.test.day3.practice1;

public class Animal {
    private String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    //    @Override
//    public String toString() {
//        return "Animal{" +
//                "animalName='" + animalName + '\'' +
//                '}';
//    }
    public String showAnimalInfo() {
        return "动物名称是：" + this.animalName;
    }
}
