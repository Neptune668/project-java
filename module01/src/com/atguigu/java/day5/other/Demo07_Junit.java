package com.atguigu.java.day5.other;

import org.junit.jupiter.api.Test;

/**
 * Junit 的功能和用法
 * 1、引入 Junit 的依赖————jar 包
 * jar 包就是把 Java 代码封装到一起的一个压缩包
 * jar 包内其实主要都是字节码文件
 *
 * 2、导入 Junit jar 包的方式
 * 以后正式的方式：Maven
 * 临时的方式：在 @Test 注解上按 Alt + Enter 选择 Add ‘Junit 5’ to classpath
 * 如果没有自动 import 就自己手动添加一下：
 * import org.junit.jupiter.api.Test;
 *
 * 3、什么是 classpath？
 * 字面意思：类路径
 * 功能：一个存放 *.class 字节码文件的目录
 * 内容：我们自己的 Java 源程序编译出来的字节码文件和第三方引入的依赖的 jar 包
 * 效果：只要把字节码文件加入到类路径下，我们开发时就可以使用这些字节码文件中的资源了（类、接口、配置文件……）
 */
public class Demo07_Junit {

    @Test
    public void test01() {
        System.out.println("Junit HelloWorld~~~");
    }

}
