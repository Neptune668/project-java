package com.atguigu.demo.test.day5.other;

import org.junit.Test;

public class Demo01 {
    @Test
    public void test01() {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println(i4 == i3);
        System.out.println(i1 == i2);
    }
}
