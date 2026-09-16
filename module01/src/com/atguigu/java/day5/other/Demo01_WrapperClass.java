package com.atguigu.java.day5.other;

public class Demo01_WrapperClass {

    public static void main(String[] args) {
        // 提出问题：Java 中的基本数据类型有很多功能上的不足
        // 问题 1：不能赋值为 null，当从数据库查询数据到 Java 代码中，数据库表里确实会存在 null 值的数据
        // 此时不能武断使用 0 表示 null，0 和 null 是完全不同含义的量
        // 所以基本数据类型不能赋值为 null 就不能如实反映数据库表中数据的真实情况
        // int a = null;

        // 问题 2：Java 是彻底的面向对象语言，很多场景都需要通过调用对象的方法完成特定功能
        // 拿到基本数据类型的数据也希望能够调用对象的方法来实现相关功能
        // 所以综上所述：我们完全有动力把基本数据类型封装为对象，要做到也很简单，只需要把基本数据类型都创建对应的类即可，也就是包装类
        // byte ---> Byte
        // short --> Short
        // int  ---> Integer
        // long ---> Long
        // float --> Float
        // double -> Double
        // char ---> Character
        // boolean-> Boolean

        // 以 Integer 为例看看包装类有哪些功能
        // 1、把字符串类型的整数转换为真正的整数类型
        int i = Integer.parseInt("100abc"); // java.lang.NumberFormatException: For input string: "100abc"
        System.out.println(i * 100);

        // 2、比较两个整数看谁大
        int compareResult = Integer.compare(50, 85);
        System.out.println("compareResult = " + compareResult); // -1 说明前面的数比后面的数小

        compareResult = Integer.compare(500, 85);
        System.out.println("compareResult = " + compareResult); // 1 说明前面的数比后面的数大

        // 3、把 Double 类型转换为整数类型
        Double doubleValue = Double.valueOf(5000.99999);
        int intValue = doubleValue.intValue();
        System.out.println(intValue);

        // 为了便于操作：自动装箱和自动拆箱
        // 自动装箱：基本数据类型值赋值给包装类型的变量就直接封装为对象了
        Character charObject = 'a';
        System.out.println(charObject.compareTo('b'));

        // 自动拆箱：包装类型的对象赋值给基本数据类型变量就直接降级为基本数据类型了
        boolean flag = Boolean.valueOf(false);
        System.out.println("flag = " + flag);
    }

}
