package com.atguigu.java.day4.lambda;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Demo08_StreamExercise {

    public static void main(String[] args) {
        Student[] students = generateData();

        Arrays.stream(students)
                .filter(student ->
                        Optional.ofNullable(student).isPresent() // 判空保护
                                && student.getGender().equals("女")  // 条件筛选
                                && student.getAge() > 18)  // 条件筛选
                .map(student -> {
                    // 把学生姓名转为大写
                    String upperCaseName = student.getName().toUpperCase();

                    // 把大写的学生姓名设置回 Student 对象
                    student.setName(upperCaseName);

                    // 把 Student 对象本身返回
                    return student;
                })
                .sorted((student01, student02) -> ((int)student02.getScore()) - ((int)student01.getScore()))
                .limit(3)
                .forEach(System.out::println);
    }

    public static Student[] generateData() {
        Student[] students = new Student[500];
        for (int i = 0; i < 500; i++) {
            students[i] = new Student(i * 10 + 10, i % 2 == 0 ? "女" : "男", Math.random() * 100, UUID.randomUUID().toString().substring(0, 4));
//            System.out.println(students[i]);
        }
        return students;
    }
}
