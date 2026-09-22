package com.atguigu.web.controller;

import com.atguigu.web.entity.Employee;
import com.atguigu.web.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Demo05DataController {

    // 一名一值：一个名字携带一个值
    // value 属性：指定请求参数的名称
    // required 属性：指定请求参数是否为必须，默认是 true 表示必须；如果必须提供的参数未提供就会报 400 错误
    // defaultValue 属性：给请求参数指定默认值
    // 如果请求参数名和形参名一致，可以省略 @RequestParam 注解
    @GetMapping("/param/one/name/one/value")
    public String paramOneNameOneValue(
            @RequestParam(value = "userName", required = false, defaultValue = "Peter666") String userName,
            @RequestParam(value = "password") String password,
            String userInfo) {

        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
        System.out.println("userInfo = " + userInfo);

        return "ok";
    }

    // 一名多值：一个名字携带多个值
    // xxx?team=German&team=France&team=Brazil&team=China
    // xxx?fruit=apple&fruit=banana&fruit=grape
    @GetMapping("/param/one/name/multi/value")
    public String paramOneNameMultiValue(
            @RequestParam("team") List<String> teamList,
            @RequestParam("fruit") List<String> fruitList) {

        for (String team : teamList) {
            System.out.println("team = " + team);
        }

        for (String fruit : fruitList) {
            System.out.println("fruit = " + fruit);
        }

        return "ok";
    }

    @PostMapping("/save/employee")
    // 前端传递过来的数据，正好对应实体类
    // 请求参数名称 -----> 实体类中的属性名 ----> 框架根据属性名找到 setXxx() 方法 ----> 调用 setXxx() 方法设置属性值
    // 属性名和 setXxx() 方法的对应规则：属性名首字母大写，前面加上 set
    // empName ----> EmpName ----> setEmpName
    // 此时不要求前端提供实体类对象的所有属性值，而是哪个能对应上，就注入哪个
    public String saveEmployee(Employee employee) {
        System.out.println("employee = " + employee);
        return "ok";
    }

    // 实体类对象参数前必须加 @RequestBody
    // {"empId":5, "empName":"tom"}
    @PostMapping("/json/save/employee")
    public String saveEmployeeJson(@RequestBody Employee employee) {
        System.out.println("employee = " + employee);
        return "ok";
    }

    @PostMapping("/save/student")
    public String saveStudent(@RequestBody Student student) {

        System.out.println("student = " + student);

        return "ok";
    }

    @GetMapping("/book/{author}/{price}")
    public String saveBook(
            @PathVariable("author") String author,
            @PathVariable("price") Double price) {

        System.out.println("author = " + author);
        System.out.println("price = " + price);

        return "ok";
    }

    @GetMapping("/receive/header")
    public String receiveHeader(
            @RequestHeader(value = "token", required = false, defaultValue = "missing") String token) {

        return "前端发送的 Token 值是：" + token;
    }

    @GetMapping("/receive/cookie")
    public String receiveCookie(
            // 在 @CookieValue 注解中指定 Cookie 的名称，根据名称取值
            @CookieValue(value = "atguigu_happy") String cookieValue) {

        return "后端接收到的 Cookie 值是：" + cookieValue;
    }
}
