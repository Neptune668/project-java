package com.atguigu.java.day2_1.base_grammar;

public class Demo09_OperatorLogic {

    public static void main(String[] args) {
        // 逻辑与
        System.out.println(true && false); // false
        System.out.println(true && true); // true

        // 逻辑或
        System.out.println(true || false); // true
        System.out.println(false || false); // false

        // 逻辑非（取反）
        System.out.println(!true); // false
        System.out.println(!false); // true

        // 逻辑与的短路效果：&& 符号左边的值如果可以直接得到整个逻辑表达式的值，则 && 符号右边的判断代码就不会执行
        int a = 10;
        System.out.println((10 > 50) && (++a < 18)); // 10 > 50 返回 false 可以直接确定逻辑表达式为 false 触发短路
        System.out.println("a = " + a);

        System.out.println((100 > 50) || (++a < 18)); // 100 > 50 返回 true 可以直接确定逻辑表达式为 true 触发短路
        System.out.println("a = " + a);
    }

}
