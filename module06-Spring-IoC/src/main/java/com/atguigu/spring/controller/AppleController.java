package com.atguigu.spring.controller;

import com.atguigu.spring.service.api.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppleController {

    // 需求：从 IoC 容器中找到 AppleService 对象然后自动赋值给当前成员变量
    @Autowired // 自动装配
    private AppleService appleService;

    public String hello() {
        // 假设这是一个前端请求要调用的方法
        // 这里我们想调用 AppleService 来获取一个数据结果
        String helloData = appleService.getHelloData();

        return "Apple Controller Hello ..." + helloData;
    }

}
