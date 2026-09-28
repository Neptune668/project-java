package com.atguigu.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.demo.entity.Emp;
import com.atguigu.demo.service.EmpService;
import com.atguigu.demo.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【t_emp】的数据库操作Service实现
* @createDate 2026-09-28 15:30:40
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




