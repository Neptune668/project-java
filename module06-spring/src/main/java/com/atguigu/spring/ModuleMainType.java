package com.atguigu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ModuleMainType {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(ModuleMainType.class, args);
        System.out.println("ioc = " + ioc);
        String[] definitionNames = ioc.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("definitionName = " + definitionName);
        }
    }

}