package com.atguigu.java.exception;


import com.atguigu.java.day3.object_oriented_02.Car;
import com.atguigu.java.day3.object_oriented_02.CarMixed;
import com.atguigu.java.day3.object_oriented_02.CarOil;

public class Demo01_ExceptionTest {

    public static void main(String[] args) {
        // java.lang.ArithmeticException算术异常
        // System.out.println(10 / 0);

        // java.lang.NullPointerException空指针异常
        String s = null;
        System.out.println(s.length());

        // java.lang.ClassCastException类型转换异常
        Car car = new CarMixed("绿色");
        CarOil carOil = (CarOil) car;
        System.out.println(carOil);

        // java.lang.ArrayIndexOutOfBoundsException数组下标越界
        int[] nums = new int[]{5, 8, 12};
        System.out.println(nums[8]);
    }

}
