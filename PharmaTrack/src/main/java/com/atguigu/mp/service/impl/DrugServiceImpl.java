package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Drug;
import com.atguigu.mp.service.DrugService;
import com.atguigu.mp.mapper.DrugMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【t_drug(药品表)】的数据库操作Service实现
* @createDate 2026-09-29 18:46:34
*/
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug>
    implements DrugService{

}




