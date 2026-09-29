package com.atguigu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo01 {
    @GetMapping("/demo")
    public String hello() {
        return "Hello, World!";
    }
}
