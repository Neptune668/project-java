package com.atguigu.java.day3.object_oriented_02;

public class Fruit {

    private int fruitId;
    protected String fruitName;
    protected double fruitPrice;

    public void showFruitInfo() {
        System.out.println(this.fruitName + " 的价格是：" + this.fruitPrice);
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
}
