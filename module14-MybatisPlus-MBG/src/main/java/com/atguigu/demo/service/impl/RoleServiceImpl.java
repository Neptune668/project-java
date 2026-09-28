package com.atguigu.demo.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.atguigu.demo.entity.Role;
import com.atguigu.demo.service.RoleService;
import com.atguigu.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author bamboo
* @description 针对表【t_role(角色表)】的数据库操作Service实现
* @createDate 2026-09-28 15:27:56
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




