package com.atguigu.java.day2_1.base_grammar;

public class Demo19_Exercise {

    public static void main(String[] args) {
        // 1、创建一个数组，保存学生的成绩
        int[] scoreArray = {35, 28, 77, 57, 89, 95};

        // 2、针对数组执行各种信息统计
        // [1]统计总分
        int sumResult = 0;

        for (int i = 0; i < scoreArray.length; i++) {
            sumResult = sumResult + scoreArray[i];
        }
        System.out.println("sumResult = " + sumResult);

        // [2]统计平均分
        int avgScore = sumResult / scoreArray.length;
        System.out.println("avgScore = " + avgScore);

        // [3]最高分
        int maxScore = scoreArray[0];

        for (int i = 1; i < scoreArray.length; i++) {
            if (scoreArray[i] > maxScore) {
                maxScore = scoreArray[i];
            }
        }
        System.out.println("maxScore = " + maxScore);

        // [4]及格人数
        int okStuCount = 0;
        for (int i = 0; i < scoreArray.length; i++) {
            if (scoreArray[i] >= 60) {
                okStuCount++;
            }
        }
        System.out.println("okStuCount = " + okStuCount);

        // 3、按等级分类
        // 大于等于90分：等级A
        // [80, 90)：等级B
        // [70, 80)：等级C
        // [60, 70)：等级D
        // 小于60：等级E
        for (int score : scoreArray) {
            if (score >= 90) {
                System.out.println(score + " 等级：A");
            } else if (score >= 80 && score < 90) {
                System.out.println(score + " 等级：B");
            } else if (score >= 70 && score < 80) {
                System.out.println(score + " 等级：C");
            } else if (score >= 60 && score < 70) {
                System.out.println(score + " 等级：D");
            } else {
                System.out.println(score + " 等级：E");
            }
        }
        System.out.println("-------------------------------------");
        for (int score : scoreArray) {

            // 使用 switch 语句计算分数对应的等级
            String grade = switch (score / 10 % 10) {
                case 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "E";
            };

            System.out.println(score + " 等级：" + grade);
        }
    }

}
