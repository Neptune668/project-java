package com.atguigu.java.day3.object_oriented_02;

public class Princess {

    /**
     * 公主请上车：公主家有很多车，当前方法不能定死具体某一辆车，而是要在实际具体出行时才决定具体哪一辆
     * 所以方法的形参要声明成一个统一的父类类型，用于兼容各个不同的子类类型！
     * @param car
     */
    public void princessPleaseUpCar(String activate, Car car) {
        System.out.print("公主要参加" + activate + "活动，");
        car.carRun();

        // 场景：如果公主今天坐的是新能源车，就要播放音乐
        // 父类类型中没有这个方法：car.playMusic();
        // 盲目、鲁莽的执行转换，有可能抛出：java.lang.ClassCastException 类转换异常
        // 正确的做法是：判断一下当前 car 对象是否为 CarElectric 类型
        // 『变量 instanceof 类型』语法含义：看这个变量指向的对象是否是指定类型的实例
        if (car instanceof CarElectric) {
            CarElectric carElectric = (CarElectric) car;
            carElectric.playMusic();
        }
    }

}
