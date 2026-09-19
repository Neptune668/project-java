package com.atguigu.demo.test.day5.other;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo03 {
    @Test
    public void test01() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");


        LocalDateTime date = LocalDateTime.now();
        System.out.println(date);
        System.out.println(formatter.format(date));
//        LocalDate date = LocalDate.parse("2025-06-04", formatter);
//        System.out.println(date);
        String s = date.format(formatter);
        System.out.println(s);
        System.out.println(LocalDateTime.parse(s, formatter));
    }
}
