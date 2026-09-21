package com.atguigu.tx.service.impl;

import com.atguigu.tx.dao.api.EmpDao;
import com.atguigu.tx.entity.Employee;
import com.atguigu.tx.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 标记在类上，对类中每个方法都生效
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public void updateTwice() {
        // 测试目标：看事务是否生效
        // 1、执行第一次更新
        Employee employee01 = new Employee();
        employee01.setEmpId(2);
        employee01.setEmpName("工作的时候称植物");
        employee01.setEmpSalary(10000.00);
        empDao.updateEmployee01(employee01);

        // 2、执行第二次更新
        Employee employee02 = new Employee();
        employee02.setEmpId(4);
        employee02.setEmpName("京圈大佬");
        employee02.setEmpSalary(20000.00);
        empDao.updateEmployee02(employee02);
    }
}
