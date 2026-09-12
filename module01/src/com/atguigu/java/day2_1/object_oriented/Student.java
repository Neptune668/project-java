package com.atguigu.java.day2_1.object_oriented;

public class Student {

    // 全局范围内做数据统计非常适合使用静态变量来实现
    private static int totalStudents = 0;

    private String name;
    private int age;

    // 无参构造器
    public Student() {
        // 调用另外那个有参的构造器
        this("默认的学生姓名", 0);
    }

    // 有参构造器
    public Student(String name, int age) {
        this.name = name;
        this.age = age;

        // 累加学生对象的数量：每创建一个对象，就给总数量 +1
        totalStudents++;
    }

    // 返回当前学生总数
    public static int getTotalStudents() {
        return totalStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
