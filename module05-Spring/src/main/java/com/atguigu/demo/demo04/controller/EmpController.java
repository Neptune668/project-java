package com.atguigu.demo.demo04.controller;

import com.atguigu.demo.demo04.service.app.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    public String hello() {
        // 假设这是一个前端请求要调用的方法
        // 这里我们想调用 AppleService 来获取一个数据结果
        String helloData = empService.getHelloData();

        return "Apple Controller Hello ..." + helloData;

    }
}
