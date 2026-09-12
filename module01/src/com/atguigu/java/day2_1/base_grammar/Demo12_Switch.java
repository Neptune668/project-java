package com.atguigu.java.day2_1.base_grammar;

//import com.atguigu.java.object_oriented.Apple;

public class Demo12_Switch {

    public static void main(String[] args) {
        String season = "春天2222";

        // 常规用法
        switch (season) {
            case "春天" -> System.out.println("春天，该播种了~~~");
            case "夏天" -> System.out.println("夏天，该耕地了~~~");
            case "秋天" -> System.out.println("秋天，该收获了~~~");
            case "冬天" -> System.out.println("冬天，该打麻将了~~~");
            default -> System.out.println("输入错误！！！"); // 前面各个分支都不匹配时执行
        }

        // 把 switch 整体作为一个表达式，让它最终返回一个确定的值
        // 此时要求 switch 各个分支能够涵盖传入变量的所有情况的值，如果不能穷举所有值就通过 default 分支覆盖所有其它情况
        String englishSeason = switch (season) {
            case "春天" -> "Spring";
            case "夏天" -> "Summer";
            case "秋天" -> "Autumn";
            case "冬天" -> "Winter";
            default -> "输入错误~~~";
        };
        System.out.println("englishSeason = " + englishSeason);

    }

}
