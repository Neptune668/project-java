package com.atguigu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(value = "com.atguigu.spring.demo2")
public class ModuleMainType {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(ModuleMainType.class, args);
        System.out.println("ioc = " + ioc);
        String[] dn = ioc.getBeanDefinitionNames();
        for (String s : dn) {
            System.out.println("s = " + s);
        }
    }
}
