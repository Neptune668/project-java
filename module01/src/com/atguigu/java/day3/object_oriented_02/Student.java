package com.atguigu.java.day3.object_oriented_02;

public class Student extends Person{

    @Override
    public Integer showInfo(String studentName) {
        return ("I am a student.My name is " + studentName).length();
    }

}
