package com.atguigu.java.day4.lambda;

public class Student {

    private int age;
    private String gender;
    private double score;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int age, String gender, double score) {
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(int age, String gender, double score, String name) {
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.name = name;
    }

    public Student() {
    }
}
