package com.atguigu.mp.mapper;

import com.atguigu.mp.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YuanYi
* @description 针对表【t_dept(部门表)】的数据库操作Mapper
* @createDate 2026-09-29 17:04:12
* @Entity com.atguigu.mp.entity.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    Dept selectDeptWithEmployees(Integer deptId);
}




