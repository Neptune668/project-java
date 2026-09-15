package com.atguigu.java.day4.lambda;

import java.util.Arrays;
import java.util.LongSummaryStatistics;

public class Demo05_ArrayProcess {

    public static void main(String[] args) {
        int[] scoreArray = {25, 36, 27, 11, 87, 92, 38};
        // 数组中所有数据的总和
        int totalScore = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            totalScore = totalScore + scoreArray[i];
        }
        System.out.println("totalScore = " + totalScore);

        // 数组中所有数据的平均数
        int avgScore = totalScore / scoreArray.length;
        System.out.println("avgScore = " + avgScore);

        // 数组中的最高分
        int maxScore = scoreArray[0];
        for (int i = 1; i < scoreArray.length; i++) {
            if (scoreArray[i] > maxScore) {
                maxScore = scoreArray[i];
            }
        }
        System.out.println("maxScore = " + maxScore);

        // 使用 Stream API 处理数组数据
        LongSummaryStatistics summariedStatistics =
                Arrays.stream(scoreArray)
                        .asLongStream() // 创建 Stream 对象
                        .summaryStatistics(); // 终结操作（本例中没有中间操作）

        System.out.println(summariedStatistics.getSum());
        System.out.println(summariedStatistics.getAverage());
        System.out.println(summariedStatistics.getMax());
        System.out.println(summariedStatistics.getMin());

        System.out.println("---------------------");

        // 一旦调用了终结操作方法，前面的 Stream 对象就会失效，想再进行操作就重新创建 Stream 对象
        Arrays.stream(scoreArray).asLongStream()
                .filter(score -> score % 2 == 1)
                .forEach(System.out::println);
    }

}
