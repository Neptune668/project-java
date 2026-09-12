package com.atguigu.java.day2.object_oriented;

public class Demo03_FishTest {

    public static void main(String[] args) {
        // 1、调用自定义两个参数的构造器创建对象
        Fish fish = new Fish("罗非鱼", 50.88);
        System.out.println("fish.fishName = " + fish.fishName);
        System.out.println("fish.fishPrice = " + fish.fishPrice);

        // 2、调用无参构造器创建对象
        // 我们自定义了有参构造器，系统就不再提供无参构造器了！！！
        Fish fish2 = new Fish();
        System.out.println("fish2.fishName = " + fish2.fishName);
        System.out.println("fish2.fishPrice = " + fish2.fishPrice);
    }

}
