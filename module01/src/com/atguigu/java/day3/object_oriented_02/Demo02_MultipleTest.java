package com.atguigu.java.day3.object_oriented_02;

public class Demo02_MultipleTest {

    public static void main(String[] args) {
        // 1、创建燃油车对象并调用车跑跑方法
        Car car01Oil = new CarOil("红色");
        car01Oil.carRun();

        // 2、创建新能源车对象并调用车跑跑方法
        Car car02Electric = new CarElectric("绿色");
        car02Electric.carRun();

        // 3、创建混动车对象并调用车跑跑方法
        Car car03Mixed = new CarMixed("黄色");
        car03Mixed.carRun();

        System.out.println("----------------------");

        // 提问：我明明可以让子类变量指向子类对象，为什么要整多态这么难理解的概念？
        CarOil carOil = new CarOil("白色");
        carOil.carRun();

        // 回答：在公主坐车出行这个场景，类中的方法不能确定具体子类对象，需要在调用方法时传入一个具体的子类对象
        Princess princess = new Princess();
        princess.princessPleaseUpCar("慈善舞会", car01Oil);
        princess.princessPleaseUpCar("新能源峰会", car02Electric);
        princess.princessPleaseUpCar("海滨度假", car03Mixed);

        // 打印 Car 类中定义的常量
        System.out.println(Car.CAR_SEQUENCE);
    }

}
