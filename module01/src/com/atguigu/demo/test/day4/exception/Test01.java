package com.atguigu.demo.test.day4.exception;

public class Test01 {
    public static void main(String[] args) {
        //异常编程：编写一段代码，读取数组下标元素，捕获数组越界异常，并输出自定义错误提示。
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
        }
    }
}
