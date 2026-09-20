package com.atguigu.demo.demo_config;


import com.atguigu.demo.demo.CarFactory;
import com.atguigu.demo.demo.CarMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:atguigu/atguigu.properties")
public class DemoConfig01 {
    @Bean
    public CarFactory carFactory() {
        return new CarFactory("比亚迪工厂", 333.33, carMachine());
    }
    @Bean
    public CarMachine carMachine() {
        return new CarMachine("比亚迪·秦", 100000.00);
    }
}
