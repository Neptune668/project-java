package com.atguigu.demo.test;

import com.atguigu.demo.demo.CarFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;


@Component
@SpringBootTest
public class Demo01 {
    @Autowired
    private CarFactory carFactory;
    @Test
    public void test01() {
        System.out.println(new CarFactory());
        System.out.println(carFactory);
    }
    @Test
    public void test02() {

    }
}
