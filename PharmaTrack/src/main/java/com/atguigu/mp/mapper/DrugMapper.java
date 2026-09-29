package com.atguigu.mp.mapper;

import com.atguigu.mp.entity.Drug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YuanYi
* @description 针对表【t_drug(药品表)】的数据库操作Mapper
* @createDate 2026-09-29 18:46:34
* @Entity com.atguigu.mp.entity.Drug
*/
@Mapper
public interface DrugMapper extends BaseMapper<Drug> {

}




