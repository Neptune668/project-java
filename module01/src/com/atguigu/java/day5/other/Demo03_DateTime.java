package com.atguigu.java.day5.other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo03_DateTime {

    public static void main(String[] args) {
        // 1、获取当前的日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前的日期时间 = " + now);

        // 2、把 now 格式化为我们熟悉格式的字符串
        // [1]创建一个封装格式的对象
        // yyyy 用四位数字表示年
        // MM 用两位数字表示月
        // HH 用两位数字表示小时，24小时制
        // hh 用两位数字表示小时，12小时制
        // mm 用两位数字表示的分钟
        // ss 用两位数字表示的秒
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");

        // [2]执行格式化
        String formattedDateTime = formatter.format(now);
        System.out.println("格式化的日期时间字符串 = " + formattedDateTime);
        System.out.println(now.format(formatter));//这个和上面一样
//         3、日期时间字符串转换为对应的日期时间对象
//         下面代码会抛出：java.lang.ClassCastException类型转换异常
//         parse() 方法返回的是 java.time.format.Parsed 对象，不是 LocalDateTime
//         LocalDateTime localDateTime = (LocalDateTime) formatter.parse(formattedDateTime);
//         正确做法是下面的代码
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);
        System.out.println("解析得到的日期时间对象 = " + parsedDateTime);
    }

}
