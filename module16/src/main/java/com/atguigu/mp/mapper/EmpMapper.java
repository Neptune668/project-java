package com.atguigu.mp.mapper;

import com.atguigu.mp.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YuanYi
* @description 针对表【t_emp】的数据库操作Mapper
* @createDate 2026-09-29 17:04:12
* @Entity com.atguigu.mp.entity.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    Emp selectEmpWithDeptXml(int i);

}




