package com.atguigu.spring.demo3;

import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:a.properties")
public class Config01 {
    @Value("${a}")
    private String a;
}
