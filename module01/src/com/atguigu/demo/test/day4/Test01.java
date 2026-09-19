package com.atguigu.demo.test.day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, 12, 30);   // 2017-12-31，周日

        // 小写 y：日历年
        DateTimeFormatter yFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("yyyy-MM-dd: " + date.format(yFormatter));   // 2017-12-31

        // 大写 Y：周年
        DateTimeFormatter YFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        System.out.println("YYYY-MM-dd: " + date.format(YFormatter));   // 2018-12-31

        // 大写 Y 加周信息
        DateTimeFormatter YWFormatter = DateTimeFormatter.ofPattern("YYYY-ww");
        System.out.println("YYYY-ww: " + date.format(YWFormatter));     // 2018-01

        //System.out.println(
//                LocalDate.of(2017, 12, 31)
//                        .format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))；
//        );

    }
}
