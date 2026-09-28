package com.atguigu.mp.mapper;

import com.atguigu.mp.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    Dept selectDeptByIdWithEmpList(Integer deptId);
}
