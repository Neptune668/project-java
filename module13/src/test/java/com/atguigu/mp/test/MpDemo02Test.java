package com.atguigu.mp.test;

import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.DeptMapper;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MpDemo02Test {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Test
    public void testSelectAll() {
        employeeMapper.selectAll1().forEach(System.out::println);
    }
    @Test
    public void test02() {
        // 需求：查询单个 Employee 对象，要求同时关联它对应的部门
        Integer empId = 13;

        Employee employee = employeeMapper.selectEmpByIdWithDept(empId);

        System.out.println(employee.getEmpName() + " 所在部门：" + employee.getDept().getDeptName());
    }
    @Test
    public void test03() {
        // 需求：查询单个 Dept 对象，要求同时关联它对应的员工对象集合
        Integer deptId = 2;

        Dept dept = deptMapper.selectDeptByIdWithEmpList(deptId);

        System.out.println("部门id：" + dept.getDeptId() + " 部门名称：" + dept.getDeptName());

        dept.getEmpList().forEach(employee ->
                System.out.println(employee.getEmpId() + " 名字：" + employee.getEmpName()));
    }

}
