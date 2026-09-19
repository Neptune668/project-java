package com.atguigu.demo.test.day5;

import org.junit.Test;

public class Demo01_1 {
    @Test
    public void test01() {
        // 1、把字符串类型的整数转换为真正的整数类型
//        int i = Integer.parseInt("123abv");//java.lang.NumberFormatException
//        System.out.println(i);
        // 2、比较两个整数看谁大
        int i = Integer.compare(50, 85);
        System.out.println(i);//-1负数后者大
        // 3、把 Double 类型转换为整数类型
        Double v = Double.valueOf(5000.99999);
        int i1 = v.intValue();
        System.out.println(i1);

        // 为了便于操作：自动装箱和自动拆箱2
        Integer i2 = 3;
        int i3 = i2;
        System.out.println(i3);
    }
}
