package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Drug;
import com.atguigu.mp.service.DrugService;
import com.atguigu.mp.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YuanYi
 * @description 针对表【t_drug(药品表)】的数据库操作Service实现
 * @createDate 2026-09-29 18:46:34
 */
@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug>
        implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public void increaseStock(String drugName, int quantity) {

        // 1. 数量校验：<=0 直接提示
        validateQuantity(quantity);

        // 2. 按药品名判断药品是否存在（drug_name 唯一）
        Drug drug = lambdaQuery()
                .eq(Drug::getDrugName, drugName)
                .one();
        if (drug == null) {
            throw new RuntimeException("药品不存在：" + drugName);
        }

        // 3. 条件更新：库存原子自增 stock = stock + quantity
        boolean updated = lambdaUpdate()
                .eq(Drug::getDrugName, drugName)
                .setSql("stock = stock + " + quantity)
                .update();
        if (!updated) {
            throw new RuntimeException("入库失败：" + drugName);
        }

    }

    @Override
    public void decreaseStock(String drugName, int quantity) {
        // 1. 数量校验：<=0 直接提示
        validateQuantity(quantity);

        // 2. 按药品名判断药品是否存在（drug_name 唯一）
        Drug drug = lambdaQuery()
                .eq(Drug::getDrugName, drugName)
                .one();
        if (drug == null) {
            throw new RuntimeException("药品不存在：" + drugName);
        }
        // 3.出库
        boolean updated = lambdaUpdate().eq(Drug::getDrugName, drugName)
                .setSql("stock=stock -" + quantity)
                .update();
        if (!updated) {
            throw new RuntimeException("入库失败：" + drugName);
        }
    }

    @Override
    public void validateQuantity(int quantity) {
        System.out.println("输入数量<=0时给出提示");
    }
}




