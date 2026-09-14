package com.atguigu.java.day3.object_oriented_02;

public class CarOil extends Car{

    public CarOil(String carColor) {
        super(carColor, "燃油发动机");
    }

    @Override
    public void carRun() {
        System.out.println(this.carColor + "颜色的车车依靠" + this.engine + "，在跑跑~~~[冒烟烟~~~]");
    }
}
