package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class MpDemo01Test {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void test01() throws SQLException {
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    }
    @Test
    public void test02(){
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }
    public void test03(){

    }
    public void test04(){

    }
}
