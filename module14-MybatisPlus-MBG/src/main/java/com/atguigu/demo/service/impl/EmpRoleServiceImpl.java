package com.atguigu.demo.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.atguigu.demo.entity.EmpRole;
import com.atguigu.demo.service.EmpRoleService;
import com.atguigu.demo.mapper.EmpRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author bamboo
* @description 针对表【t_emp_role(员工-角色中间表)】的数据库操作Service实现
* @createDate 2026-09-28 15:27:56
*/
@Service
public class EmpRoleServiceImpl extends ServiceImpl<EmpRoleMapper, EmpRole>
    implements EmpRoleService{

}




