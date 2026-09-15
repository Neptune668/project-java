package com.atguigu.java.day4.lambda;

import com.atguigu.java.object_oriented_02.Car;

import java.util.Optional;

public class Demo04_OptionalTest {

    public static void main(String[] args) {
        // 1、传统的判空方式
        Employee employee01 = new Employee();
        String fetchResult = fetchDeptName(employee01);
        System.out.println("fetchResult = " + fetchResult);

        Employee employee02 = new Employee(new Department("人力资源部"));
        fetchResult = fetchDeptName(employee02);
        System.out.println("fetchResult = " + fetchResult);

        // 2、使用 Optional 方式进行优雅的判空
        fetchResult = fetchDeptNameByOptional(employee01);
        System.out.println("fetchResult = " + fetchResult);

        fetchResult = fetchDeptNameByOptional(employee02);
        System.out.println("fetchResult = " + fetchResult);

        // 3、测试一下 Optional 的 get() 方法
        // get() 方法使用需慎重：Optional 中封装的对象为 null 时，调用 get() 方法会抛异常；所以适合用于确定非空的场景
        Department department = Optional.ofNullable(employee01.getDepartment()).get();
        System.out.println("department = " + department);
    }

    public static String fetchDeptName(Employee employee) {
        if (employee != null) {
            Department department = employee.getDepartment();

            if (department != null) {
                return department.getDeptName();
            }
        }

        return "部门名称未找到~~~";
    }

    public static String fetchDeptNameByOptional(Employee employee) {

        Department department = Optional.ofNullable(employee)
                .orElse(new Employee())
                .getDepartment();

        return Optional.ofNullable(department)
                .orElse(new Department("未指定部门名称"))
                .getDeptName();

    }

    public static String fetchDeptNameByOptional2(Employee employee) {

        // 1、把 Employee 对象封装到 Optional 对象中
        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);

        // orElse() 方法：如果 Optional 对象中封装的 Employee 对象是空的，就返回 orElse() 方法中传入的
        employee = optionalEmployee.orElse(new Employee());

        // 2、通过 Employee 对象获取 Department 对象
        Department department = employee.getDepartment();

        // 3、再把 Department 封装到 Optional 对象中
        department = Optional.ofNullable(department).orElse(new Department("未指定部门名称"));

        // 4、获取部门名称
        return department.getDeptName();
    }
}
