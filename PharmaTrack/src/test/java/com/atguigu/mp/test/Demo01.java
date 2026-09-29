package com.atguigu.mp.test;

import com.atguigu.mp.entity.Drug;
import com.atguigu.mp.mapper.DrugMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 【题目】药品出入库管理
 * 【场景】药品入库增加库存；出库减少库存（库存不足拒绝）；
 * 查询低于预警阈值的药品列表。
 * 【表结构】
 *   t_drug(drug_id int 主键自增, drug_name varchar(30) 唯一,
 *   stock int, warn_line int 预警阈值)
 * 【功能要求】
 *   1. 入库：按药品名增加库存；
 *   2. 出库：校验库存充足后扣减，不足给出提示；
 *   3. 查询所有"库存<预警阈值"的药品（低库存预警列表）；
 *   4. 按药品名模糊查询药品及库存；
 *   5. 输入数量<=0时给出提示。
 * 【考察要点】条件更新扣减、预警比较查询、模糊查询
 */

@SpringBootTest
public class Demo01 {
    @Autowired
    private DrugMapper drugMapper;
    @Test
    public void test01() {
//        LambdaQueryWrapper<Drug> wrapper = new LambdaQueryWrapper<>();
////        drugMapper.update()
//        wrapper.eq(Drug::getDrugName, "阿司匹林");
//        drugMapper.update(null, wrapper);
    }
}