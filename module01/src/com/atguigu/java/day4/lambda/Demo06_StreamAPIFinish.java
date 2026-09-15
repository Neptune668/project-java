package com.atguigu.java.day4.lambda;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 专门测试 Stream API 的终结操作
 */
public class Demo06_StreamAPIFinish {

    public static void main(String[] args) {
        // 1、调用 collect() 方法执行收集操作
        String[] nameArr = {"a", "b", "c", "d", "e"};
        String collectResult = Arrays.stream(nameArr).collect(Collectors.joining("@"));
        System.out.println("collectResult = " + collectResult);

        System.out.println("------------------");

        // 2、调用 forEach() 方法遍历流中的各个元素
        Arrays.stream(nameArr).forEach(name -> {
            System.out.println("name = " + name);
        });

        System.out.println("------------------");

        // 3、调用 reduce() 方法把流中的各个元素归并为一个值
        Optional<String> optional = Arrays.stream(nameArr)
                .reduce((prevValue, nextValue) -> prevValue + "---" + nextValue);
        String reduceResult = optional.get();
        System.out.println("reduceResult = " + reduceResult);

        System.out.println("------------------");

        // 4、调用 anyMatch() 方法检测流中各个元素是否有至少一个满足特定要求
        boolean anyMatchResult =
                Arrays.stream(nameArr).anyMatch(name -> name.equals("c"));
        System.out.println("anyMatchResult = " + anyMatchResult);

        // 5、调用 allMatch() 方法检测流中各个元素是否全部满足特定要求
        boolean allMatchResult = Arrays.stream(nameArr).allMatch(name -> name.length() > 0);
        System.out.println("allMatchResult = " + allMatchResult);
    }

}
