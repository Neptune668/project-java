package com.atguigu.demo.test.day3.test3;

public class Manager extends Employee{
    String name;

    public Manager(String name) {
        super(name);
    }

    @Override
    double getSalary() {
        return 8000;
    }
}
