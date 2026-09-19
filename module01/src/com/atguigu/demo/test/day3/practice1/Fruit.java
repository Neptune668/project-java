package com.atguigu.demo.test.day3.practice1;

public class Fruit {
    private String fruitName;
    private double fruitPrice;

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

    public void showFruitInfo() {
        System.out.println(this.fruitPrice + " 的价格是：" + this.fruitPrice);
    }
}

