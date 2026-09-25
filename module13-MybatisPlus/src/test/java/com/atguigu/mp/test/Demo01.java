package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
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
        int i = employeeMapper.insert(new Employee(null, "0002", "张三", new BigDecimal(10000), null, null, null));
        System.out.println(i);
    }
    @Test
    public void Test03(){
        int i = employeeMapper.deleteById(6);
        System.out.println(i);
    }
    @Test
    public void Test04(){
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }
    @Test
    public void Test05(){
        QueryWrapper<Employee> wrapper = new QueryWrapper<Employee>().eq("emp_name", "沙瑞金");
        int delete = employeeMapper.delete(null);
        System.out.println(delete);
//        int i = employeeMapper.deleteById();
//        System.out.println(i);
    }
    @Test
    public void Test06(){
        int i = employeeMapper.deleteById(1);
        System.out.println(i);
    }
    @Test
    public void Test07(){
        List<Employee> list = employeeMapper.selectByIds(Arrays.asList(1, 2, 3));
        list.forEach(System.out::println);
    }
}
