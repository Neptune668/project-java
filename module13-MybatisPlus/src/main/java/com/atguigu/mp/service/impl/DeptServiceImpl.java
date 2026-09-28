package com.atguigu.mp.service.impl;

import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.mapper.DeptMapper;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.service.api.DeptService;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Autowired
    private EmployeeMapper employeeMapper;

}
