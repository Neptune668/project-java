package com.atguigu.mp.test;

import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MpDemo02Test {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testSelectAll() {
        employeeMapper.selectAll1().forEach(System.out::println);
    }
}
