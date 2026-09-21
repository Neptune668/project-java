package com.atguigu.spring.demo3;

public class CarMachine {

    private String carName;
    private Double carPrice;

    @Override
    public String toString() {
        return "CarMachine{" +
                "carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                '}';
    }

    public CarMachine(String carName, Double carPrice) {
        this.carName = carName;
        this.carPrice = carPrice;
        System.out.println("CarMachine[有参构造器]");
    }

    public CarMachine() {
        System.out.println("CarMachine[无参构造器]");
    }

}
