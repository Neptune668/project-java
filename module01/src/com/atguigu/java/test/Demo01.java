package com.atguigu.java.test;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        int[] scores = {10, 20, 44, 66, 27, 97, 66, 55};
        test(scores);
    }

    public static void test(int[] scores) {
        int min_score = 0;//最低分
        int max_score = 0;//最高分
        int avg_score;//平均分
        int pass_num = 0;//及格人数
        int sum = 0;//总分
        Arrays.sort(scores);
        System.out.print("排序后的成绩为：");
        for (int score : scores) {
            System.out.print(score + ",");
        }
        System.out.println();
        for (int i = 0; i < scores.length; i++) {
            min_score = scores[0];
            max_score = scores[scores.length - 1];
            sum += scores[i];
            if (scores[i] > 60) {
                pass_num += 1;
            }
        }
        String[] level = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            String s = test2(scores[i]);
            level[i] = s;
        }
        for (String s : level) {
            System.out.print(s + ",");
        }
//        大于等于90分：等级A
//        [80, 90)：等级B
//        [70, 80)：等级C
//        [60, 70)：等级D
//        小于60：等级E

        avg_score = sum / scores.length;
        System.out.println("及格人数为：" + pass_num);
        System.out.println("最低分为：" + min_score);
        System.out.println("最高分为：" + max_score);
        System.out.println("平均分为：" + avg_score);
    }

    //统计各等级人数
    public static String test2(int score) {
        String level;
        switch (score / 10) {
            case 10, 9 -> level = "A";
            case 8 -> level = "B";
            case 7 -> level = "C";
            case 6 -> level = "D";
            default -> level = "E";
        }
        return level;
    }
}
