package com.atguigu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;

// SpringBoot 主启动类要求必须用 @SpringBootApplication 注解标记
@SpringBootApplication
// @ComponentScan("edu.banana.happy.demo")
public class MainType01_IoC {

    public static void main(String[] args) {
        // SpringBoot 启动过程的入口
        ConfigurableApplicationContext ioc = SpringApplication.run(MainType01_IoC.class, args);

        // 在 IoC 容器中已经定义的 bean 的名称
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 可能的疑问：
        // 1、为什么我们的类本来是 Demo01Cmp 这个名字，打印出来却成了：demo01Cmp？
        // 答：我们打印的是 bean 的名称，也叫 bean 的 id，它是一个 bean 在 IoC 容器中存放时的唯一标识，并不是类名本身

        // 2、什么是 bean？
        // 答：IoC 容器创建和管理的对象

        // 3、为什么除了我们的 bean 还有很多其它打印？
        // 答：其它的打印是 IoC 容器创建框架内部自己需要使用的组件对象

        // 4、bean 名称的命名规范？
        // 答：默认情况以类名首字母小写作为 bean 的名称；想自己定制就在 @Component 注解中用 value 属性指定

        // 5、Spring 是怎么知道我们在自己的类上写了一个注解？
        // 答：这是因为 Spring 在底层扫描了我们所有的类

        // 6、Spring 扫描包、类是无限的范围吗？
        // 答：不是！SpringBoot 有一个默认的包扫描范围
        // 这个默认范围就是：主启动类所在的包、以及主启动类所在包的子包

        // 7、SpringBoot 默认的包扫描范围怎么修改？
        // 答：在主启动类上使用 @ComponentScan 注解指定其它的包
        // @ComponentScan("edu.banana.happy.demo")
        // 注意：一旦修改了扫描范围，默认的扫描范围就失效了！！！
    }

}
