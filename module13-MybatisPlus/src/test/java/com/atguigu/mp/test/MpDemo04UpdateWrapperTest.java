package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

@SpringBootTest
public class MpDemo04UpdateWrapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() {
        String newEmpName = "孙悟空";

        // 总体效果：整体上构造一条 UPDATE 语句
        // UPDATE t_emp SET emp_name=?,emp_salary=? WHERE (emp_name = ?)
        employeeMapper.update(new LambdaUpdateWrapper<Employee>()
                .set(StringUtils.hasLength(newEmpName), Employee::getEmpName, newEmpName) // 用于只修改部分字段的场景
                .set(Employee::getPhoneNumHappy, "15088992233")
                .setSql("emp_salary = emp_salary * 1.1") // 传入 SQL 语句中 SET 子句的片段
                .eq(Employee::getEmpName, "齐天大圣")); // 封装查询条件的部分和 LambdaQueryWrapper 是一样的

    }
}
