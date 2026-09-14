package com.atguigu.java.day3.object_oriented_02;

import com.atguigu.java.day3.object_oriented_02.Apple;
import com.atguigu.java.day3.object_oriented_02.Banana;

public class Demo01_ExtendsTest {

    public static void main(String[] args) {
        // 1、创建 子类的对象
        Apple apple = new Apple();
        Banana banana = new Banana();

        // 2、设置属性值
        apple.setFruitName("苹果");
        apple.setFruitPrice(555.55);

        banana.setFruitName("香蕉");
        banana.setFruitPrice(999.99);

        // 3、调用方法打印水果信息
        apple.showFruitInfo();
        banana.showFruitInfo();

        // 4、使用 Apple（子类）自己扩展的成员
        Apple appleOther = new Apple("红", "大");
        appleOther.showAppleInfo();

        // 5、调用从 Object 类继承的 toString() 方法
        // 关于 toString() 方法：大部分情况不需要我们自己明确手动调用
        // sout 打印一个对象时，编译器会自动调用 toString() 方法
        // 用 + 符号做字符串拼接时会自动调用 toString() 方法
        // 没有重写时：com.atguigu.java.object_oriented_02.Apple@5f184fc6
        System.out.println(appleOther);
        System.out.println("字符串拼接会自动调用  toString() 方法：" + appleOther);

        // 6、创建 Tiger 的对象，测试子类调用父类成员
        Tiger tiger = new Tiger("东北虎");
        tiger.printTigerInfo();

    }

}
