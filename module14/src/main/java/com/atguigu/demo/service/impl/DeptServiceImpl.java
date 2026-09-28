package com.atguigu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.demo.entity.Dept;
import com.atguigu.demo.service.DeptService;
import com.atguigu.demo.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【t_dept(部门表)】的数据库操作Service实现
* @createDate 2026-09-28 15:30:40
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




