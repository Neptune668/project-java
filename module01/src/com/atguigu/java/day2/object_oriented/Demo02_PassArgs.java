package com.atguigu.java.day2.object_oriented;

/**
 * 在 Java 中不管是基本数据类型还是引用类型，给方法传参时都是『值传递』
 * 所谓值传递就是把变量的值复制一份，传递给方法的参数
 * 区别是：
 * 基本数据类型变量的值就是数据本身；
 * 引用类型变量的值是地址值，在被调用的方法体内会根据地址值找到指向的那个数组或对象，这样一来方法内外操作的就是相同的东西了
 */
public class Demo02_PassArgs {

    public static void main(String[] args) {
        // 测试场景 1：给方法传递基本数据类型的参数
        int value = 50;
        add(value);
        System.out.println("方法外打印：value = " + value);

        // 测试场景 2：给方法传递引用类型的参数
        int[] nums = {10, 20, 30};
        incr(nums);
        System.out.println("方法外打印下标 1 位置元素：" + nums[1]);
    }

    public static void add(int value) {
        value = value + 100;
        System.out.println("方法内打印：value = " + value);
    }

    public static void incr(int[] nums) {
        // 给下标 1 这个位置的元素乘以 10，计算结果再重新赋值回下标 1 这个位置
        nums[1] = nums[1] * 10;
        System.out.println("方法内打印下标 1 位置元素：" + nums[1]);
    }
}
