package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public void test02() {
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }

    @Test
    public void test03() {
        String name = "高育良";
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>().eq(name != null & name.length() > 0, "emp_name", name);
        System.out.println("queryWrapper = " + queryWrapper);
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        employees.forEach(System.out::println);
    }
    //分页
    @Test
    public void test04() {
        Page<Employee> page = new Page<>(1, 2);
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<Employee>().lt(Employee::getEmpSalary, 30000).and(
                i -> i.gt(Employee::getEmpSalary, 2)
        ).orderByAsc(Employee::getEmpSalary);
        employeeMapper.selectList(page,wrapper).forEach(System.out::println);
        System.out.println("----------------------------------");
//        page.getRecords().forEach(System.out::println);
    }
    //分页详细测试
    @Test
    public void test05() {
        Page<Employee> page = new Page<>(1, 2);
        employeeMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("page = " + page);
    }

    //逻辑删除
    @Test
    public void test06(){
//        int i = employeeMapper.deleteById(7);
//        System.out.println("i = " + i);
        employeeMapper.selectAll();
    }
}
