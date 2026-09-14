package com.atguigu.java.day3.object_oriented_02;

public class CarMixed extends Car{

    public CarMixed(String carColor) {
        super(carColor, "双引擎");
    }

    @Override
    public void carRun() {
        System.out.println(this.carColor + "颜色的车车依靠" + this.engine + "，在跑跑~~~[肥嘟嘟~~~]");
    }
}
