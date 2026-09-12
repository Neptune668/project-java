package com.atguigu.java.day2_1.object_oriented;


import com.atguigu.java.day2_1.object_oriented.child.AppleChild;

public class Demo06_Apple {

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setPropNamePrivate("AAAAAAAA");
        apple.setPropNameDefault("wwwww");
        apple.setPropNameProtected("uuuuuuuu");
        apple.setPropNamePublic("werwer");

        // 同包的类不能访问私有属性
        // apple.propNamePrivate = "666666";

        // 同包的其它类可以访问默认属性
        apple.propNameDefault = "66666666";

        // 同包的其它类可以访问受保护属性
        apple.propNameProtected = "dddddddddd";

        // 同包的其它类可以访问公共属性
        apple.propNamePublic = "mmmmmmmmmmm";

        // 创建子类对象，测试相关范围
        AppleChild appleChild = new AppleChild();
        appleChild.doSth();
    }

}
