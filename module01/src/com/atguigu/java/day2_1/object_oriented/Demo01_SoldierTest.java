package com.atguigu.java.day2_1.object_oriented;

public class Demo01_SoldierTest {

    public static void main(String[] args) {
        // 1、创建 Soldier 类的对象
        // 底层行为说明：
        // [1]new Soldier() 是在堆内存中开辟一块空间
        // [2]Soldier soldier 是声明一个 Soldier 类型的变量
        // [3]赋值是把 Soldier 对象在堆空间中的地址赋值给 soldier 变量
        // [4]所在内存空间：对象在堆内存中，局部变量在栈内存中
        // [5]堆内存中的对象必须通过指向它的变量才能被找到
        Soldier soldier = new Soldier();

        // 2、操作对象属性
        // 最初打印对象，看到：全类名@hash码
        // 全类名：带有包名的类名
        // 提出需求：打印对象时看到对象中各个属性的值，为此需要给类增加 toString() 方法
        // 快捷键：在类中空白处按 Alt + Insert 调出 Generate 菜单
        // 增加 toString() 方法之后，看到对象的各个属性都是默认值
        System.out.println("在对象中设置属性之前soldier = " + soldier);

        // 设置对象的属性
        soldier.soldierName = "许三多";
        soldier.soldierWeapon = "八一杠";
        soldier.age = 23;
        soldier.salary = 3333.33;
        System.out.println("在对象中设置属性之后soldier = " + soldier);

        Soldier soldier2 = new Soldier();
        System.out.println("另外创建的soldier对象 = " + soldier2);

        // 针对对象属性做读操作
        System.out.println("[单独访问对象属性]士兵姓名：" + soldier.soldierName);
        System.out.println("[单独访问对象属性]士兵武器：" + soldier.soldierWeapon);
        System.out.println("[单独访问对象属性]士兵年龄：" + soldier.age);
        System.out.println("[单独访问对象属性]士兵工资：" + soldier.salary);

        // 3、调用对象的方法
        soldier.attack();
        soldier.attack("车力巨人");
        soldier.defense();
    }

}
