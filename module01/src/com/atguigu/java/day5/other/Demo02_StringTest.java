package com.atguigu.java.day5.other;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Demo02_StringTest {

    public static void main(String[] args) {
        // Java 中 String 类型是一个不可改变的字符序列，substring()、replace() 等方法是返回新字符串，原字符串不变
        String s = "   abc123---XYZ---@u    v@---NMO---@uvw.png     ";
        String subString = s.substring(3, 6);
        System.out.println("subString = " + subString);
        System.out.println("s = " + s);

        // String 常用方法
        System.out.println("字符串长度：" + s.length());
        System.out.println("返回指定 index 6 位置的字符：" + s.charAt(6) + " index 从 0 开始");
        System.out.println("截取字符串：" + s.substring(3) + "[单个参数：从指定位置开始截取到字符串结束]");
        System.out.println("截取字符串：" + s.substring(3, 6) + "[两个参数：从参数1位置截取到参数2前一个字符，这是个半闭半开区间]");
        System.out.println("返回指定子串第一次出现的位置：" + s.indexOf("@"));
        System.out.println("返回指定子串第一次出现的位置：" + s.indexOf("uvw"));
        System.out.println("返回指定子串第一次出现的位置：" + s.indexOf(".png"));
        System.out.println("举例截取文件名的扩展名部分：" + s.substring(s.indexOf(".png")));
        System.out.println("检查字符串是否包含指定的子串：" + s.contains(".png"));
        System.out.println("检查字符串是否以指定子串开头：" + s.startsWith("abcd"));
        System.out.println("把字符串全部转换为大写：" + s.toUpperCase());
        System.out.println("把字符串全部转换为小写：" + s.toLowerCase());
        System.out.println("去除字符串头尾空格：" + s.trim());
        System.out.println("替换字符串中的指定内容：" + s.replace("---", "***"));
        System.out.println("把字符串根据指定正则表达式拆分为数组：" + Arrays.toString(s.split("@")));
        System.out.println("把数组根据指定字符串拼接成一个字符串：" + String.join("%", "aaa", "bbb", "ccc"));

        Integer[] nums = new Integer[]{1, 2, 3, 5, 6};
        String arrToStr = Arrays.toString(nums);
        System.out.println("把非字符串类型的数组转换为字符串 = " + arrToStr);

        // 字符串判空
        // 第一层：先检查是否为 null 值
        // 第二层：再检查是否为空字符串
        // 空字符串：双引号之间没有任何字符，哪怕写一个空格都不是空字符串；null 也不是空字符串，"null"也不是空字符串
        // null 在 Java 中表示彻底的空值，什么值都没有，用 null 值访问成员变量或调用方法就会抛出空指针异常
        // 空指针异常：java.lang.NullPointerException
        // 结论：『emptyStr.isEmpty() || emptyStr == null ? "无效字符串" : "有效字符串"』这种写法不安全
        // 正确：emptyStr == null || emptyStr.isEmpty() ? "无效字符串" : "有效字符串"
        String emptyStr = null;
        System.out.println("字符串是否为空：" + (emptyStr == null || emptyStr.isEmpty() ? "无效字符串" : "有效字符串"));
    }

}
