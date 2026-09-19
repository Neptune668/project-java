package com.atguigu.demo.demo_config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:atguigu/atguigu.properties")
public class DemoConfig01 {
}
