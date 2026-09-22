package com.atguigu.demo.controller;

import com.atguigu.demo.entity.Result;
import com.atguigu.demo.entity.Tiger;
import com.atguigu.demo.service.api.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiger")
public class TigerController {

    @Autowired
    private TigerService tigerService;

    @GetMapping("/list")
    public Result<List<Tiger>> queryTigerList() {

        try {
            // 调用 Service 方法执行查询
            List<Tiger> tigerList = tigerService.getTigerList();

            // 把查询结果封装到 Result 对象返回
            return Result.success(tigerList);
        } catch (Exception e) {

            // 打印异常信息栈
            e.printStackTrace();

            // 把错误信息封装到 Result 对象中返回
            return Result.failed(e.getMessage());
        }
    }

    @DeleteMapping("/{tigerId}")
    public Result<Void> removeTigerById(@PathVariable("tigerId") Integer tigerId) {

        try {
            tigerService.removeTigerById(tigerId);

            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }

    @GetMapping
    public Result<Void> saveTiger(Tiger tiger) {

        try {
            tigerService.saveTiger(tiger);

            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }

    @GetMapping("/{tigerId}")
    public Result<Tiger> getTigerById(@PathVariable Integer tigerId) {

        try {
            Tiger tiger = tigerService.getTigerById(tigerId);

            return Result.success(tiger);
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }

    @PutMapping
    public Result<Void> updateTiger(@RequestBody Tiger tiger) {

        try {
            tigerService.updateTiger(tiger);

            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }
}
