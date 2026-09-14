package com.atguigu.java.day3.object_oriented_homework;

public class Car {

    private String brandName = "未知";
    private double price;

    public Car(String brandName) {
        this.brandName = brandName;
    }

    public Car(String brandName, double price) {
        this.brandName = brandName;
        this.price = price;
    }

    public Car() {
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Car car01 = new Car();
        System.out.println("car01.getBrandName() = " + car01.getBrandName());
        System.out.println("car01.getPrice() = " + car01.getPrice());

        Car car02 = new Car("小米");
        System.out.println("car02.getBrandName() = " + car02.getBrandName());
        System.out.println("car02.getPrice() = " + car02.getPrice());

        Car car03 = new Car("比亚迪", 666.66);
        System.out.println("car03.getBrandName() = " + car03.getBrandName());
        System.out.println("car03.getPrice() = " + car03.getPrice());
    }
}
