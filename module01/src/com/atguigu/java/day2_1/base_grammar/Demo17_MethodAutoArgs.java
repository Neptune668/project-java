package com.atguigu.java.day2_1.base_grammar;

public class Demo17_MethodAutoArgs {

    public static void main(String[] args) {
        System.out.println(mul(1, 2, 3, 5, 10));
    }

    // 可变参数：传入参数的数量不确定
    // 可变参数必须是整个参数列表中最后的位置
    // 可变参数在整个参数列表中只能有一个
    public static int mul(int initValue, int ... nums) {
        int result = initValue;

        // 在函数体内，可变参数会被当做数组来使用
        for (int i = 0; i < nums.length; i++) {
            result = result * nums[i];
        }

        return result;
    }
}
