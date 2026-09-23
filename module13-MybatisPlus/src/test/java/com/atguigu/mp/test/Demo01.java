package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class Demo01 {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void Test01(){
        List<Employee> employees = employeeMapper.selectList(null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void Test02(){
        int i = employeeMapper.insert(new Employee(null, "0001", "张三", new BigDecimal(10000), null, null, null));
        System.out.println(i);
    }
}
