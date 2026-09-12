package com.atguigu.java.day2_1.object_oriented;

public class Flower {

    String flowerName;
    double flowerPrice;

    public Flower() {
        // 通过 this 调用另一个有参的构造器
        this("默认名称·郁金香", 66666.66);

        System.out.println("无参构造器执行~~~");

        // 效果和下面的代码等价：相当于简化代码
        // this.flowerName = "默认名称·郁金香";
        // this.flowerPrice = 66666.66;
    }

    public Flower(String flowerName, double flowerPrice) {
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;

        System.out.println("有参构造器执行~~~");
    }
}
