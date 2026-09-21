package com.atguigu.spring.test;

import com.atguigu.spring.demo3.CarFactory;
import com.atguigu.spring.demo3.CarMachine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Demo03_1 {
    @Autowired
    private CarMachine carMachine;
    @Autowired
    private CarFactory carFactory;
    @Test
    public void test01(){
        System.out.println(carMachine);

        System.out.println(carFactory);
    }
}
