package com.atguigu.java.day3.object_oriented_02;

// final 修饰一个类：这个类将不能被继承
public abstract  /*final*/ class Car {

    // final 修饰变量，变量只能被赋值一次，成为一个常量
    public static final String CAR_SEQUENCE = "车辆出厂序列号钢印335588";

    protected String carColor;
    protected String engine;

    public Car(String carColor, String engine) {
        this.carColor = carColor;
        this.engine = engine;
    }

    public Car() {
    }

    // final 修饰方法：方法不能被重写
//    public /*final*/ void carRun() {
//        System.out.println(this.carColor + "颜色的车车依靠" + this.engine + "，在跑跑~~~");
//    }

    // 每个子类都覆盖重写了父类的这个方法，所以看起来父类的这个方法体没有实际用途
    // 那就不如声明为抽象方法，在父类中省略具体实现
    public abstract void carRun();
}
