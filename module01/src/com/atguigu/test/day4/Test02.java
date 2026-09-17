package com.atguigu.test.day4;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test02 {
    @Test
    public void test01() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.parse("2024-12-30 12:34:56", formatter)
                .format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))); // 2025-12-30
    }
}
