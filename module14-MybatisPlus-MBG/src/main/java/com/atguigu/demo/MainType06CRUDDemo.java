package com.atguigu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.demo.mapper")
public class MainType06CRUDDemo {

    public static void main(String[] args) {
        SpringApplication.run(MainType06CRUDDemo.class, args);
    }

}
