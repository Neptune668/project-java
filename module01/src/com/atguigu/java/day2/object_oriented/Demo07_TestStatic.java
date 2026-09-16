package com.atguigu.java.day2.object_oriented;

public class Demo07_TestStatic {

    static {
        System.out.println("静态代码块~~~在类被加载后执行~~~因为类只加载一次，所以静态代码块也只执行一次");

        // 和 main() 方法一样，静态代码块也是一种静态上下文
        // System.out.println(this);
    }

    static {
        System.out.println("我是第二个静态代码块~~~");
    }

    {
        System.out.println("非静态代码块~~~创建对象时执行~~~");
    }

    private String nonStaticValue = "非静态属性【我喜欢小动物~~~】";

    private static String privateInfo = "Demo07_TestStatic类的静态成员变量【私有】";
    public static String publicInfo = "Demo07_TestStatic类的静态成员变量【公共】";

    public static void main(String[] args) {
        // 读写静态私有成员变量
        System.out.println("privateInfo = " + Demo07_TestStatic.privateInfo);
        privateInfo = "修改静态成员变量的值【私有】";
        System.out.println("privateInfo = " + Demo07_TestStatic.privateInfo);

        // 读写静态公共成员变量
        System.out.println("publicInfo = " + Demo07_TestStatic.publicInfo);
        publicInfo = "修改静态成员变量的值【公共】";
        System.out.println("publicInfo = " + Demo07_TestStatic.publicInfo);

        // 可以通过对象访问静态属性，但没有必要，通过类名访问更简洁直接
        Demo07_TestStatic demo07TestStatic = new Demo07_TestStatic();
        demo07TestStatic.publicInfo = "AAA";
        System.out.println("publicInfo = " + Demo07_TestStatic.publicInfo);

        // 调用静态工具方法举例
        System.out.println("-10的绝对值是：" + Math.abs(-10));

        // 在静态上下文中不能访问非静态的资源
        // 底层逻辑：静态上下文属于类级别的资源，在静态上下文中的代码执行时完全没有办法确定当前对应哪个对象，也可能尚未创建对象
        // 而所有非静态资源都是和对象直接相关的、都是从属于某一个对象的！
        // [1]非静态属性
        // System.out.println("访问非静态属性：" + nonStaticValue);

        // [2]this
        // System.out.println("访问this关键词：" + this);

        // [3]调用非静态方法
        // showInfo();

        // 创建当前类的对象，查看非静态代码块是否执行
        new Demo07_TestStatic();
        new Demo07_TestStatic();
        new Demo07_TestStatic();
    }

    public void showInfo() {

    }
}
