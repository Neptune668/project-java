package com.atguigu.test.day4.lambda;

/**
 * 当前接口是一个函数式接口，将来在使用中必然会产生一个抽象方法的实现方法
 * 函数式编程：不关心是哪个类、哪个对象调用实现方法，只关心实现方法中做什么操作；所以应该把操作以外所有无关的代码舍弃
 */
@FunctionalInterface
public interface SayHello {

    void hello();

}
