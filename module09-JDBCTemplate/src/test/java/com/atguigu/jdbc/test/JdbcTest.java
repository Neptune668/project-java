package com.atguigu.jdbc.test;

import com.atguigu.jdbc.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class JdbcTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01Conn() throws SQLException {
        // 获取数据库连接
        Connection connection = dataSource.getConnection();

        // 打印
        // HikariProxyConnection@1459462244 wrapping com.mysql.cj.jdbc.ConnectionImpl@788e3702
        System.out.println("connection = " + connection);

        // 常见故障举例：
        // 密码错误：Access denied for user 'root'@'192.168.100.1' (using password: YES)
        // 连接超时：Connection timed out（ IP 地址错误、防火墙阻拦端口号、MySQL 服务没有启动……）
        // 数据库名称错误：Unknown database 'db_hr260525E'
        // 驱动类的全类名写错：Cannot load driver class: com.mysql.cj.jdbc.Driver222
    }

    @Test
    public void test02() {
        // org.springframework.jdbc.core.JdbcTemplate@5f0bab7e
        System.out.println("jdbcTemplate = " + jdbcTemplate);
    }

    @Test
    public void test03() {
        // 增删改操作
        // 问号占位符：解决 SQL 注入问题
        // now() 在 SQL 语句中出现，调用的是 MySQL 的函数，返回当前日期
        String sql = """
                    insert into t_emp(emp_no,
                                      emp_name,
                                      emp_salary,
                                      emp_birthday,
                                      phone_num,
                                      dept_id)
                    values (?, ?, ?, now(), ?, ?)
                    """;

        // update() 方法给 SQL 语句传入的参数会按顺序依次传给问号占位符
        jdbcTemplate.update(sql, "5555", "侯亮平", 992233.55, "18800107925", 13);
    }

    @Test
    public void test04() {
        String sql = """
        select emp_id empId,
        emp_no empNo,
        emp_name empName,
        emp_salary empSalary,
        emp_birthday empBirthday,
        phone_num phoneNum,
        dept_id deptId from t_emp where emp_id=?
        """;
        Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 3);
        System.out.println("employee = " + employee);
    }

    @Test
    public void test05() {
        String sql = """
        select emp_id empId,
        emp_no empNo,
        emp_name empName,
        emp_salary empSalary,
        emp_birthday empBirthday,
        phone_num phoneNum,
        dept_id deptId from t_emp
        """;
        List<Employee> employeeList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void test06() {
        String sql = "select max(emp_salary) from t_emp";
        Double maxSalary = jdbcTemplate.queryForObject(sql, Double.class);
        System.out.println("maxSalary = " + maxSalary);
    }
}
