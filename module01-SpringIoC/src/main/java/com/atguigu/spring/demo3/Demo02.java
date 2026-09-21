package com.atguigu.spring.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Demo02 {
    @Bean
    public CarMachine carMachine() {
        return new CarMachine("比亚迪·秦", 100000.00);
    }
    @Bean
    public CarFactory carFactory() {
        return new CarFactory("比亚迪工厂", 333.33, carMachine());
    }
}
