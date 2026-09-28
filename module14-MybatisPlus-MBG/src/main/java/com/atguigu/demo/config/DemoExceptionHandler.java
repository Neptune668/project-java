package com.atguigu.demo.config;

import com.atguigu.demo.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<Void> globalExceptionHandler(Exception exception) {

        // 为了方便调试程序，在控制台打印异常堆栈信息
        exception.printStackTrace();

        return Result.failed(exception.getMessage());
    }

}
