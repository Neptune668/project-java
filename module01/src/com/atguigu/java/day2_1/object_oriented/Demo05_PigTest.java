package com.atguigu.java.day2_1.object_oriented;

public class Demo05_PigTest {

    public static void main(String[] args) {
        Pig pig = new Pig();

        // 1、调用普通的 set 方法设置对象的属性
        pig.setPigName("香香猪");
        pig.setPigPrice(666.66);

        // 2、用连缀调用的方式设置对象属性
        pig.setPigNameSelf("金金猪")
           .setPigPriceSelf(888.88);
    }

}
