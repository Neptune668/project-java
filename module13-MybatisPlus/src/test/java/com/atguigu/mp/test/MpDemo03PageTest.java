package com.atguigu.mp.test;

import com.atguigu.mp.entity.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MpDemo03PageTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test01() {
        // 分页前的准备
        // 1、创建 Page 对象，封装分页参数
        // [1]分页参数一：页码
        int pageNum = 6;

        // [2]分页参数一：页容量
        int pageSize = 10;

        IPage<Employee> page = new Page<>(pageNum, pageSize);

        // 2、创建 QueryWrapper 对象，封装查询条件（根据业务需求创建）
        LambdaQueryWrapper<Employee> queryWrapper = null;

        // 核心方法
        employeeMapper.selectPage(page, queryWrapper);

        // 分页查询结束之后，MybatisPlus 会把分页相关数据存入 IPage 对象————就是前面作为参数传入的那个
        long current = page.getCurrent();
        System.out.println("当前页的页码：" + current);

        long pages = page.getPages();
        System.out.println("总页数：" + pages);

        long size = page.getSize();
        System.out.println("页容量：" + size);

        List<Employee> employeeList = page.getRecords();
        employeeList.forEach(System.out::println);

        long totalRecord = page.getTotal();
        System.out.println("总记录数：" + totalRecord);
    }
}
