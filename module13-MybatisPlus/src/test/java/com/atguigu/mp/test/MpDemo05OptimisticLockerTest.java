package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MpDemo05OptimisticLockerTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() {
        Employee employee = employeeMapper.selectById(29);
        System.out.println("初始版本号：" + employee.getVersion());

        employee.setEmpName("齐天大圣");
        // version 属性没有值的时候，乐观锁机制失效，但没有抛异常
        // employee.setVersion(null);

        int effectedRows = employeeMapper.updateById(employee);
        System.out.println("effectedRows = " + effectedRows);
    }

    @Test
    public void test02() {
        // 模拟并发场景：两条线分别执行更新
        Employee employeeA = employeeMapper.selectById(29);
        Employee employeeB = employeeMapper.selectById(29);

        // 第一次更新
        int effectedRows = employeeMapper.updateById(employeeA);
        System.out.println("effectedRows = " + effectedRows);

        // 第二次更新
        effectedRows = employeeMapper.updateById(employeeB);
        System.out.println("effectedRows = " + effectedRows);

        // 第二次更新失败，不甘心，想要再试一次
        if (effectedRows == 0) {
            employeeB = employeeMapper.selectById(29);
            // 第三次更新（重试）
            effectedRows = employeeMapper.updateById(employeeB);
            System.out.println("effectedRows = " + effectedRows);
        }
    }
}
