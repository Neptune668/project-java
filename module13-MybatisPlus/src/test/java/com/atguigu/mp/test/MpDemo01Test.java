package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MpDemo01Test {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    @Test
    public void test02() {
        List<Employee> employeeList =
                employeeMapper.selectList(null);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void test03() {
        Employee employee = new Employee();
        employee.setEmpNo("No.10005");
        employee.setEmpName("钱七");
        employee.setEmpSalary(new BigDecimal("9500.00"));
        employee.setEmpBirthday(new Date());
        employee.setPhoneNumHappy("13511110005");
        employee.setDeptId(2);

        int effectedRows = employeeMapper.insert(employee);
        System.out.println("effectedRows = " + effectedRows);

        // 保存操作完成后，MybatisPlus 会自动把自增的主键设置到 empId 属性中
        Integer empId = employee.getEmpId();
        System.out.println("empId = " + empId);
    }

    @Test
    public void test04() {
        int effectedRows = employeeMapper.deleteById(17);
        System.out.println("effectedRows = " + effectedRows);
    }

    @Test
    public void test05() {
        int effectedRows = employeeMapper.deleteByIds(Arrays.asList(3, 4));
        System.out.println("effectedRows = " + effectedRows);
    }

    @Test
    public void test06() {
        // 使用 Wrapper 封装查询条件，生成将来 SQL 中的 WHERE 子句：WHERE (emp_name = ?)
        QueryWrapper<Employee> wrapper = new QueryWrapper<Employee>().eq("emp_name", "沙瑞金");

        // 根据查询条件执行删除
        // 注意：employeeMapper.delete(null) 是一个非常危险的操作！这会导致整个数据库表所有数据全部删除！
        int effectedRows = employeeMapper.delete(wrapper);
        System.out.println("effectedRows = " + effectedRows);
    }

    @Test
    public void test07() {
        Employee employee = new Employee();
        employee.setEmpId(60);
        employee.setEmpName("AAAAAAAA");
        employee.setEmpSalary(new BigDecimal(99999.99));

        int effectedRows = employeeMapper.updateById(employee);
        System.out.println("effectedRows = " + effectedRows);
    }

    @Test
    public void test08() {
        Employee employee = employeeMapper.selectById(71);
        System.out.println("employee = " + employee);
    }

    @Test
    public void test09() {
        // WHERE emp_id IN ( ? , ? , ? )
        List<Employee> employeeList = employeeMapper.selectByIds(Arrays.asList(8, 9, 10));
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void test10() {
        Long count = employeeMapper.selectCount(null);
        System.out.println("count = " + count);
    }

    @Test
    public void test11() {
        // 查询单个对象不指定查询条件，有可能返回多个对象
        // SELECT emp_id,emp_no,emp_name,emp_salary,emp_birthday,dept_id FROM t_emp
        // org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) but found more than one
        Employee employee = employeeMapper.selectOne(null);
        System.out.println("employee = " + employee);
    }

    @Test
    public void test12() {
        List<Map<String, Object>> mapList = employeeMapper.selectMaps(null);
        for (Map<String, Object> dataMap : mapList) {
            System.out.println(dataMap);
        }
    }
}
