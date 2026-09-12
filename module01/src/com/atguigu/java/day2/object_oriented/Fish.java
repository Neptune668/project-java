package com.atguigu.java.day2.object_oriented;

public class Fish {

    String fishName;
    double fishPrice;

    // 实际开发时为了避免没有无参构造器带来的各种问题，最好明确声明无参构造器！！！
    public Fish() {
        System.out.println("这里是一个无参构造器~~~");
    }

    // 创建一个包含两个参数的构造器
    // 我们自定义了有参构造器，系统就不再提供无参构造器了！！！
    public Fish(String fishName, double fishPrice) {
        // 在构造器内部，使用外部参数给对象的属性赋值
        // this 关键词：代表当前对象
        // 当前局部变量和成员变量同名时，就可以使用 this. 写法区分二者
        this.fishName = fishName;
        this.fishPrice = fishPrice;
    }

}
