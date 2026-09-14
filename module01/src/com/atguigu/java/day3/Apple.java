package com.atguigu.java.day3;

public class Apple extends Fruit/* Java单继承，不能继承多个直接父类 , Animal*/{

    private String appleColor; // 黄、红、青
    private String appleSize; // 大、中、小

    public Apple() {
    }

    public Apple(String appleColor, String appleSize) {
        this.appleColor = appleColor;
        this.appleSize = appleSize;
    }

    public void showAppleInfo() {
        System.out.println("苹果的颜色：" + appleColor + " 苹果的大小：" + appleSize);
    }
}
