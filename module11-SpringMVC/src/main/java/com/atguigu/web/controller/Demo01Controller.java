package com.atguigu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController // 相当于 @ResponseBody 和 @Controller 合并在一起
public class Demo01Controller {

    // @ResponseBody 注解表示用方法返回值作为响应报文的响应体
    // @ResponseBody
    // @RequestMapping 注解负责建立从前端请求到 Controller 方法之间的映射
    // value 属性：指定前端请求的路径
    @RequestMapping(value = "/hello")
    public String helloSpringMVC() {
        System.out.println("HelloWorld SpringMVC!!!");

        return "HelloWorld SpringMVC!!!太牛了！！！";
    }

    // @ResponseBody
    @RequestMapping("/apple")
    public String apple() {
        return "apple~~~";
    }

    // @ResponseBody
    @RequestMapping("/orange")
    public String orange() {
        return "orange~~~";
    }

    // @ResponseBody
    @RequestMapping("/banana")
    public String banana() {
        return "banana~~~";
    }
}
