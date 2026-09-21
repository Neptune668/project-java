package com.atguigu.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo03PatternController {

    // /* 只能匹配路径中的一个层级
    // 下面是匹配的路径形式：
    // /animal/dog
    // /animal/pig
    // /animal/tiger
    // 下面是不匹配的路径形式：
    // /animal
    // /animal/fish/swimming
    // /animal/fish/swimming/good
    @RequestMapping("/animal/*")
    public String animal(HttpServletRequest request) {

        // 返回具体的前端请求路径
        return request.getServletPath();
    }

    // /** 可以匹配路径中的多个层级
    // /product
    // /product/phone
    // /product/phone/blue
    // /product/phone/blue/good
    @RequestMapping("/product/**")
    public String product(HttpServletRequest request) {
        return request.getServletPath();
    }

    @RequestMapping("/*.html")
    public String matchHTML() {
        return "HTML Match";
    }
}
