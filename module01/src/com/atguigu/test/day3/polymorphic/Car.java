package com.atguigu.test.day3.polymorphic;

public class Car {
    private String engine;
    private String carColor;

    public Car() {
    }
    public void RunCar(String engine,String color){
        System.out.println(this.carColor + "颜色的车车依靠" + this.engine + "，在跑跑~~~");
    }
}
