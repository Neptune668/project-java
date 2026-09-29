package com.atguigu.mp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 药品管理
 */
@RequestMapping("/drug")
@RestController
public class DrugController {
    @PostMapping("/add")
    public void addDrug() {
        System.out.println("addDrug");
    }
}
