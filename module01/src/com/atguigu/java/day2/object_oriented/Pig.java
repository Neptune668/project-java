package com.atguigu.java.day2.object_oriented;

public class Pig {

    String pigName;
    double pigPrice;

    public void setPigName(String pigName) {
        this.pigName = pigName;
    }

    public void setPigPrice(double pigPrice) {
        this.pigPrice = pigPrice;
    }

    public Pig setPigNameSelf(String pigName) {
        this.pigName = pigName;
        return this;
    }

    public Pig setPigPriceSelf(double pigPrice) {
        this.pigPrice = pigPrice;
        return this;
    }
}
