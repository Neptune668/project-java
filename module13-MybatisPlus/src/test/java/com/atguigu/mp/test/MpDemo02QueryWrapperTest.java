package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class MpDemo02QueryWrapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() {
        // 常规操作：使用 QueryWrapper 封装查询条件和排序方式
// ==>  Preparing: SELECT emp_id,emp_no,emp_name,emp_salary,emp_birthday,dept_id FROM t_emp WHERE (dept_id = ? AND emp_name LIKE ?) ORDER BY emp_salary DESC
// ==> Parameters: 1(Integer), %张%(String)
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>()
                .eq("dept_id", 1)
                .like("emp_name", "张")
                .orderByDesc("emp_salary");

        List<Employee> employeeList = employeeMapper.selectList(queryWrapper);
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void test02() {
        // 不查询业务上不关心的字段，最大限度避免浪费内存
        // SELECT emp_name,emp_salary FROM t_emp WHERE (emp_salary > ?)
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>()
                .gt("emp_salary", 50000)
                .select("emp_name", "emp_salary");

        employeeMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test03() {
        // SELECT emp_id,emp_no,emp_name,emp_salary,emp_birthday,dept_id FROM t_emp Hello Mp~~~
        employeeMapper.selectList(new QueryWrapper<Employee>().last(" Hello Mp~~~"));
    }

    @Test
    public void test04() {
        // SELECT dept_id,avg(emp_salary) as avg_salary FROM t_emp GROUP BY dept_id HAVING avg(emp_salary)>8000
        employeeMapper.selectMaps(new QueryWrapper<Employee>()
                        .select("dept_id", "avg(emp_salary) as avg_salary")
                        .groupBy("dept_id")
                        // .having("avg(emp_salary)>8000"))
                        .having("avg_salary>8000")) // HAVING 子句可以使用别名
                .forEach(System.out::println);
    }

    @Test
    public void test05() {
        String empNameCondition = "AAA";

        // 条件方法（eq()方法）第一个参数：可以传入一个 boolean 类型值
        //      true：条件方法就拼接到 SQL 语句中
        //      false：不拼接
        // 效果：前端传入有效的值，就放入 SQL 中，否则就不参与 SQL 查询条件
        employeeMapper.selectList(new QueryWrapper<Employee>()
                        .eq(empNameCondition != null && empNameCondition.length() > 0, "emp_na2me", empNameCondition))
                .forEach(System.out::println);
    }

    @Test
    public void test06() {
        BigDecimal empSalary = new BigDecimal(80000);
        String empName = "Good";

        // WHERE (emp_salary > ? AND emp_name LIKE ?)
        employeeMapper.selectList(new LambdaQueryWrapper<Employee>()
                .gt(empSalary != null, Employee::getEmpSalary, empSalary)
                .like(StringUtils.hasLength(empName), Employee::getEmpName, empName)
        ).forEach(System.out::println);
    }

    @Test
    public void test07() {
        // (emp_no = ? OR emp_name LIKE ?)
        employeeMapper.selectList(new LambdaQueryWrapper<Employee>()
                .eq(Employee::getEmpNo, "EEBBCC")
                .or()
                .like(Employee::getEmpName, "刘")
        ).forEach(System.out::println);
    }

    @Test
    public void test08() {
        // 拼接的目标：(A or B) and C
        // and(Consumer consumer)
        // Consumer 接口本身是一个消费型的函数式接口，它里面唯一的抽象方法有入参，没有返回值
        // Consumer 接口中抽象方法的入参在当前场景下其实就是前面创建的 LambdaQueryWrapper 对象
        // 所以在 Lambda 体中就可以调用 LambdaQueryWrapper 对象的方法，拼接最终目标里面括号中的查询条件
        // WHERE ((emp_no = ? OR emp_name LIKE ?) AND emp_salary BETWEEN ? AND ?)
        employeeMapper.selectList(new LambdaQueryWrapper<Employee>()
                        .and(wrapper -> wrapper.eq(Employee::getEmpNo, "EEBBCC")
                                .or()
                                .like(Employee::getEmpName, "刘"))
                        .between(Employee::getEmpSalary, new BigDecimal(50000), new BigDecimal(80000)))
                .forEach(System.out::println);
    }

    @Test
    public void test09() {
        // 目标：A or (B and C)
        // WHERE (emp_no = ? OR (emp_salary > ? AND dept_id = ?))
        employeeMapper.selectList(new LambdaQueryWrapper<Employee>()
                .eq(Employee::getEmpNo, "66633")
                .or(wrapper -> wrapper.gt(Employee::getEmpSalary, new BigDecimal(10000))
                    .eq(Employee::getDeptId, 8)))
                .forEach(System.out::println);
    }
}
