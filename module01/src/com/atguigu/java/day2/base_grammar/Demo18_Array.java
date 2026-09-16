package com.atguigu.java.day2.base_grammar;

import java.util.Arrays;

public class Demo18_Array {

    public static void main(String[] args) {
        // 1、声明数组方式一
        double[] scoreArray = new double[5];
        for (int i = 0; i < scoreArray.length; i++) {
            System.out.println("分数值：" + scoreArray[i]);
        }

        // 2、声明数组方式二
        String[] nameArrary = {"小明", "小军", "小红", "小刚", "小牛", "小马"};
        for (String name : nameArrary) {
            System.out.println("name = " + name);
        }

        // 3、声明数组方式三
        char[] charArray = new char[]{'A', 'W', 'E'};
        for (char c : charArray) {
            System.out.println("c = " + c);
        }

        // 4、错误的声明方式
        // int[5] intArray = new int[]{1, 2, 3, 4, 5};

        // 5、读取数组元素值
        System.out.println("nameArrary 数组下标 2 的元素：" + nameArrary[2]);

        // 6、把数据写入数组下标对应的位置
        charArray[1] = 'Y';
        System.out.println(charArray[1]);

        // 7、下标值超过最后一个元素就会造成数组下标越界
        // charArray[3] = 'T';

        // 8、使用 Arrays 工具类提供的 toString() 方法直接打印数组元素值
        // Arrays 需要导入才可以使用：import java.util.Arrays;
        System.out.println(Arrays.toString(charArray));
    }

}
