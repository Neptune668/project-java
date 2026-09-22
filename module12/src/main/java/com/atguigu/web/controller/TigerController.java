package com.atguigu.web.controller;

import com.atguigu.web.entity.Result;
import com.atguigu.web.entity.Tiger;
import com.atguigu.web.service.api.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/tiger")
public class TigerController {
    @Autowired
    private TigerService service;
    @GetMapping("/{tigerId}")
    public Result<Tiger> getTigerById(@PathVariable Integer tigerId) {
        try {
            Tiger tiger = service.getTigerById(tigerId);
            return Result.success(tiger);
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }
}
