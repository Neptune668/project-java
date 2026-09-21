package com.atguigu.tx.dao.impl;

import com.atguigu.tx.dao.api.EmpDao;
import com.atguigu.tx.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateEmployee01(Employee employee) {
        String sql = "update t_emp set emp_name=?, emp_salary=? where emp_id=?";
        jdbcTemplate.update(sql, employee.getEmpName(), employee.getEmpSalary(), employee.getEmpId());
    }

    @Override
    public void updateEmployee02(Employee employee) {
        String sql = "update t_emp set emp_name=?, emp_salary=? where emp_id=?";
        jdbcTemplate.update(sql, employee.getEmpName(), employee.getEmpSalary(), employee.getEmpId());
    }
}
