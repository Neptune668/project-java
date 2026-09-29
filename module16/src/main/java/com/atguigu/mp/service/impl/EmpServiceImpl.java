package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Emp;
import com.atguigu.mp.service.EmpService;
import com.atguigu.mp.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【t_emp】的数据库操作Service实现
* @createDate 2026-09-29 17:04:12
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




