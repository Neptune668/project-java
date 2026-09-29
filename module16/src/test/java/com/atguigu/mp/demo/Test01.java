package com.atguigu.mp.demo;

import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.entity.Emp;
import com.atguigu.mp.mapper.DeptMapper;
import com.atguigu.mp.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Test
    public void test01() {
        Emp employee = empMapper.selectEmpWithDeptXml(1);
        System.out.println("员工 = " + employee.getEmpName());
        System.out.println("所属部门 = " + employee.getDept().getDeptName());
    }
    @Test
    public void test02() {
        Dept dept = deptMapper.selectDeptWithEmployees(1);
        System.out.println("部门 = " + dept.getDeptName());
        dept.getEmpList().forEach(e -> System.out.println("  员工：" + e.getEmpName()));
    }
}
