package com.atguigu.spring.demo3;



public class CarFactory {

    private String factoryName;
    private Double moneyBalance;

    private CarMachine carMachine;

    @Override
    public String toString() {
        return "CarFactory{" +
                "factoryName='" + factoryName + '\'' +
                ", moneyBalance=" + moneyBalance +
                ", carMachine=" + carMachine +
                '}';
    }

    public CarFactory(String factoryName, Double moneyBalance, CarMachine carMachine) {
        this.factoryName = factoryName;
        this.moneyBalance = moneyBalance;
        this.carMachine = carMachine;
    }

    public CarFactory() {
    }
}