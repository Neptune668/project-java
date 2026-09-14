package com.atguigu.java.day3.object_oriented_02;

public class CarElectric extends Car{

    public CarElectric(String carColor) {
        super(carColor, "新能源发动机");
    }

    @Override
    public void carRun() {
        System.out.println(this.carColor + "颜色的车车依靠" + this.engine + "，在跑跑~~~[电闪闪~~~]");
    }

    public void playMusic() {
        System.out.println("[新能源车][独有]播放音乐~~~蓝色的多瑙河");
    }
}
