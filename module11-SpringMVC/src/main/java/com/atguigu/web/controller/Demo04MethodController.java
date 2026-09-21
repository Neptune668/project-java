package com.atguigu.web.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Demo04MethodController {

    // 请求映射过程中，我们指定的路径和请求方式之间是且的关系
    // 二者必须同时满足才能匹配上
    @RequestMapping(value = "/get/employee", method = RequestMethod.GET)
    public String getEmployee() {
        return "get employee";
    }

    @RequestMapping(value = "/post/employee", method = {RequestMethod.POST, RequestMethod.PUT})
    public String postEmployee() {
        return "post employee";
    }

    @GetMapping("/get/dept")
    public String getDept() {
        return "get dept";
    }

    @PostMapping("/post/dept")
    public String postDept() {
        return "post dept";
    }

    @PutMapping("/put/dept")
    public String putDept() {
        return "put dept";
    }

    @DeleteMapping("/delete/dept")
    public String deleteDept() {
        return "delete dept";
    }
}
