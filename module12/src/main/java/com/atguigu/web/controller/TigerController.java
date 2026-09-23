package com.atguigu.web.controller;

import com.atguigu.web.entity.Result;
import com.atguigu.web.entity.Tiger;
import com.atguigu.web.service.api.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/tiger")
public class TigerController {
    @Autowired
    private TigerService service;
//    查询单条数据
    @GetMapping("/{tigerId}")
    public Result<Tiger> getTigerById(@PathVariable Integer tigerId) {
        try {
            Tiger tiger = service.getTigerById(tigerId);
            System.out.println("查询到单条结果");
            return Result.success(tiger);
        } catch (Exception e) {
            e.printStackTrace();

            return Result.failed(e.getMessage());
        }
    }
    //查询表所有数据
    @GetMapping("/list")
    public Result<List<Tiger>> getTigerList(){
        try {
            // 调用 Service 方法执行查询
            List<Tiger> tigerList = service.getTigerByList();

            // 把查询结果封装到 Result 对象返回
            return Result.success(tigerList);
        } catch (Exception e) {

            // 打印异常信息栈
            e.printStackTrace();

            // 把错误信息封装到 Result 对象中返回
            return Result.failed(e.getMessage());
        }
    }
    //删除记录
//    public Result
    @DeleteMapping("/{tigerId}")
    public Result<Tiger> deleteTigerById(@PathVariable Integer tigerId) {
        try {
            service.deleteTigerById(tigerId);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed(e.getMessage());
        }
    }
    //新增记录
    @GetMapping
    public Result<Tiger> addTiger(Tiger tiger) {
        try {
            service.addTiger(tiger);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed(e.getMessage());
        }
    }
    //更新记录PUT
    @PutMapping
    public Result<Void> updateTiger(@RequestBody Tiger tiger) {
        try {
            service.updateTiger(tiger);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed(e.getMessage());
        }
    }
}
