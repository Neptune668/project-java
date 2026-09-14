package com.atguigu.java.day3.object_oriented_02;

// 用 abstract 修饰的类叫做抽象类
// 非抽象类：不能包含抽象方法
// 抽象类：可以包含抽象方法，但不是必须包含
// 抽象类不能直接实例化，因为可能存在不确定的部分（抽象方法）
public abstract class Teacher {

    // 抽象方法：只有声明的部分，没有方法体
    public abstract void talk();

    public double getSalary() {
        return 10000;
    }
}
