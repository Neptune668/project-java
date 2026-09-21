package com.atguigu.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit") // 标记在类上就要求每个方法请求路径前面都加上统一的前缀
public class Demo02FruitController {

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

    @RequestMapping("/grape")
    public String grape() {
        return "grape";
    }
}
