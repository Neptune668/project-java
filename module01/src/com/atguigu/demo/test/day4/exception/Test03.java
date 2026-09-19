package com.atguigu.demo.test.day4.exception;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Test03 {
    public static void main(String[] args) {
        String[] nameArr = new String[]{"张三", null, "李四", "", "王五"};
        Stream<String> stream = Arrays.stream(nameArr);
        stream.map(Optional::ofNullable).filter(Optional::isPresent)
                .filter(s->!s.get().equals(""))
                .forEach(s-> System.out.println(s.get()));
    }
}
