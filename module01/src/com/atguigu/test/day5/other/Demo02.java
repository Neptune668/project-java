package com.atguigu.test.day5.other;

import org.junit.Test;

import java.util.Arrays;

public class Demo02 {
    @Test
    public void test01() {
        String str = " 12345678901234567890 ";
        System.out.println(str.substring(0, 1));
//        str.substring(0, 2));
        // String 常用方法
        // "字符串长度："
        System.out.println(str.length());
        // "返回指定 index 6 位置的字符：""截取字符串：" + s.substring(3) + "[单个参数：从指定位置开始截取到字符串结束]");
        System.out.println(str.substring(6,7));
        System.out.println(str.charAt(6));
        // "截取字符串：" + s.substring(3, 6) + "[两个参数：从参数1位置截取到参数2前一个字符，这是个半闭半开区间]");
        // "返回指定子串第一次出现的位置
        System.out.println(str.indexOf("1"));
        // "返回指定子串第一次出现的位置
        // "返回指定子串第一次出现的位置
        // "举例截取文件名的扩展名部分：" + s.substring(s.indexOf(".png")));
        // "检查字符串是否包含指定的子串：" + s.contains(".png"));
        System.out.println(str.contains("123"));
        // "检查字符串是否以指定子串开头：" + s.startsWith("abcd"));
        System.out.println(str.startsWith("12"));
        // "把字符串全部转换为大写：" + s.toUpperCase());
        // "把字符串全部转换为小写：" + s.toLowerCase());
        // "去除字符串头尾空格：" + s.trim());
        System.out.println(str.trim().length());
        // "替换字符串中的指定内容：" + s.replace("---", "***"));
        System.out.println(str.replace("0", "x"));
        // "把字符串根据指定正则表达式拆分为数组：" + Arrays.toString(s.split("@")));

        // "把数组根据指定字符串拼接成一个字符串：" + String.join("%", "aaa", "bbb", "ccc"));

    }
}
