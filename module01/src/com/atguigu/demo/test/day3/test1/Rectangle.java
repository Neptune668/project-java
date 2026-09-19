package com.atguigu.demo.test.day3.test1;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width*length;
    }
}
