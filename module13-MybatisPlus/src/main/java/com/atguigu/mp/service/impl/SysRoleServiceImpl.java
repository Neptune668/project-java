package com.atguigu.mp.service.impl;

import com.atguigu.mp.entity.SysRole;
import com.atguigu.mp.mapper.SysRoleMapper;
import com.atguigu.mp.service.api.SysRoleService;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}
