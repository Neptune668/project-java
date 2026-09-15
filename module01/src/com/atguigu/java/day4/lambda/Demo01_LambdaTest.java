package com.atguigu.java.day4.lambda;

public class Demo01_LambdaTest {

    public static void main(String[] args) {
        // 1、传统方式实现接口（四步）
        SayHello sayHello = new SayHelloImpl();
        sayHello.hello();

        // 2、匿名内部类实现接口（三步）
        SayHello sayHello02 = new SayHello() {
            @Override
            public void hello() {
                System.out.println("匿名内部类的实现方式~~~");
            }
        };
        sayHello02.hello();

        // 3、Lambda 表达式（两步）
        // 复制小括号，写死右箭头，落地大括号
        SayHello sayHello03 = () -> {
            System.out.println("Lambda表达式的实现方式~~~");
        };
        sayHello03.hello();
    }

}
