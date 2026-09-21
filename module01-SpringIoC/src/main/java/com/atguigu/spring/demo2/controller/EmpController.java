package com.atguigu.spring.demo2.controller;

import com.atguigu.spring.demo2.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;

    public String hello() {
        String save = empService.save();
        return "hello i'm controller" + save;
    }
}
