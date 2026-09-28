package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.service.api.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MpDemo06ServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test01() {
        Employee employee = Employee.builder()
                .empName("牛魔王")
                .empNo("No.332233")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(6666.66))
                .phoneNumHappy("1311111111")
                .deptId(3)
                .build();
        boolean saveResult = employeeService.save(employee);
        System.out.println(saveResult ? "保存成功！" : "保存失败！");

        Integer empId = employee.getEmpId();
        System.out.println("empId = " + empId);
    }

    @Test
    public void test02() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder()
                .empName("铁扇公主")
                .empNo("No.38822")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(227777.33))
                .phoneNumHappy("1555555555")
                .deptId(3)
                .build());
        employeeList.add(Employee.builder()
                .empName("红孩儿")
                .empNo("No.11111")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(111111.111))
                .phoneNumHappy("1113234324")
                .deptId(3)
                .build());

        boolean saveResult = employeeService.saveBatch(employeeList);

        System.out.println(saveResult ? "保存成功！" : "保存失败！");

        employeeList
                .stream()
                .map(employee -> employee.getEmpId())
                .forEach(System.out::println);
    }

    @Test
    public void test03() {
        employeeService.saveOrUpdate(Employee.builder()
                .empId(167)
                .empName("白骨精6666")
                .empNo("No.66666")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(66666))
                .phoneNumHappy("66666")
                .deptId(6)
                .build());
    }

    @Test
    public void test04() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder()
                .empId(65)
                .empName("铁扇公主")
                .empNo("No.38822")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(227777.33))
                .phoneNumHappy("1555555555")
                .deptId(3)
                .build());
        employeeList.add(Employee.builder()
                .empId(66)
                .empName("红孩儿")
                .empNo("No.11111")
                .empBirthday(new Date())
                .empSalary(new BigDecimal(111111.111))
                .phoneNumHappy("1113234324")
                .deptId(3)
                .build());

        boolean updateResult = employeeService.updateBatchById(employeeList);
        System.out.println(updateResult ? "更新成功" : "更新失败");
    }

    @Test
    public void test05() {
        employeeService.list(new LambdaQueryWrapper<Employee>()
                .eq(Employee::getDeptId, 3))
                .forEach(System.out::println);
    }

    @Test
    public void test06() {
        // SELECT emp_name,emp_salary,emp_birthday FROM t_emp WHERE is_deleted=0 AND (emp_salary > ? AND emp_name = ?)
        employeeService.lambdaQuery()
                .gt(Employee::getEmpSalary, 50000)
                .eq(Employee::getEmpName, "孙悟空")
                .select(Employee::getEmpName, Employee::getEmpSalary, Employee::getEmpBirthday)
                .list()
                .forEach(System.out::println);
    }

    @Test
    public void test07() {
        employeeService.lambdaUpdate()
                .set(Employee::getEmpNo, "No.887722")
                .set(Employee::getEmpBirthday, new Date())
                .setSql("emp_salary=emp_salary * 1.1")
                .eq(Employee::getDeptId, 3)
                .update();
    }
}
