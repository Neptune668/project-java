package com.atguigu.java.day3.object_oriented_02;

import com.atguigu.java.day3.object_oriented_02.Animal;

public class Tiger extends Animal {

    public Tiger() {
        super();
        // this("默认老虎名称");
    }

    public Tiger(String animalName) {
        // 调用父类的有参构造器，对父类中的成员变量进行初始化，让子类可以不必写这部分代码
        super(animalName);

        // 验证：打印通过 super(参数) 初始化的父类属性值
        System.out.println("打印父类的成员变量值：animalName = " + super.animalName);
    }

    public void printTigerInfo() {
        System.out.println("[子类]老虎信息：" + super.showAnimalInfo());
    }
}
