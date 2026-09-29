package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Dept;
import com.atguigu.mp.service.DeptService;
import com.atguigu.mp.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【t_dept(部门表)】的数据库操作Service实现
* @createDate 2026-09-29 17:04:12
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




