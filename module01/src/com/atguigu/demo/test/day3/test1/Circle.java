package com.atguigu.demo.test.day3.test1;

class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }
    @Override
    public double area() {
        return 3.14*r*r;
    }
}
