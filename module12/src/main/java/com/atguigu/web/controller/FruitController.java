package com.atguigu.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @GetMapping
    public String one() {
        System.out.println("[目标 Controller 方法][one]");
        return "OK fruit" + (10 / 0);
    }


    @GetMapping("/apple/red")
    public String appleRed() {
        System.out.println("[目标 Controller 方法][appleRed]");
        return "OK fruit apple red" + (10 / 0);
    }

    @GetMapping("/apple/red/sweet")
    public String appleRedSweet() {
        System.out.println("[目标 Controller 方法][appleRedSweet]");
        String emptyStr = null;
        emptyStr.length();
        return "OK fruit apple red sweet";
    }

    @GetMapping("/orange")
    public String orange() {
        System.out.println("[目标 Controller 方法][orange]");
        return "OK fruit orange";
    }

    @GetMapping("/orange/blue")
    public String orangeBlue() {
        System.out.println("[目标 Controller 方法][orangeBlue]");
        return "OK fruit orange blue";
    }

    @GetMapping("/orange/blue/acid")
    public String orangeBlueAcid() {
        System.out.println("[目标 Controller 方法][orangeBlueAcid]");
        return "OK fruit orange blue acid";
    }
}
