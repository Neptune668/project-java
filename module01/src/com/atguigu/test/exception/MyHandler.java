package com.atguigu.test.exception;

public interface MyHandler<T> {
    void handle(T t);
}
