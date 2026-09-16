package com.atguigu.java.day2.base_grammar;

public class Demo15_Method {

    public static void main(String[] args) {
        // 调用下面声明的方法
        // 1、静态方法不必创建对象，可以通过类名直接调用。这个方法会返回一个字符串，我们声明一个变量来接收
        String helloInfo = Demo15_Method.sayHello("齐天大圣");
        System.out.println("helloInfo = " + helloInfo);

        // 2、静态方法必须通过对象调用，所以我们需要先创建对象，再调用方法
        // [1]创建方法所在类的对象
        Demo15_Method demo = new Demo15_Method();

        // [2]调用对象的方法
        System.out.println(demo.sum(5, 10));
    }

    // 声明一个静态方法，功能是针对传入的姓名返回打招呼的字符串
    public static String sayHello(String monkeyName) {
        System.out.println("sayHello()函数执行了，传入的参数是：" + monkeyName);
        return "Hello!" + monkeyName;
    }

    // 声明一个非静态方法，功能是把传入的两个整数加起来返回
    public int sum(int i, int j) {
        return i + j;
    }
}
