package com.atguigu.java.day5.other;

/**
 * Java 中的注解：@开头的语法结构
 * 功能：对代码中的特定位置进行标记，让所在环境知道这里需要做什么操作
 * 注意：注解本身什么都不做，围绕注解的操作都是环境完成的，注解本身只做一个标记
 *
 * 元注解
 * @Target(ElementType.METHOD) 规定注解可以标记在代码中的什么位置，比如：类、成员变量、方法、方法的参数……
 * @Retention(RetentionPolicy.SOURCE) 规定注解在从开发、编译到运行的过程中能保持到什么阶段
 *  RetentionPolicy.SOURCE 表示仅保留在源码中，编译成字节码文件时就去掉了，相当于注释
 *  RetentionPolicy.CLASS 表示会随编译进入字节码文件，在字节码文件中能够提取出来
 *  RetentionPolicy.RUNTIME 表示字节码文件中的代码运行时仍然，这个注解有效【常用】
 */
public class Demo06_Annotation {

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
