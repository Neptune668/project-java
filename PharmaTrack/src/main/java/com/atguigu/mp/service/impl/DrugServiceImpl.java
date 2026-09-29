package com.atguigu.mp.service.impl;

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
    implements DrugService{
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public void increaseStock(String drugName, int quantity) {

    }

    @Override
    public void decreaseStock(String drugName, int quantity) {
        System.out.println("2. 出库：校验库存充足后扣减，不足给出提示；");
    }

    @Override
    public List<Drug> listLowStock() {
        System.out.println("3. 查询所有\"库存<预警阈值\"的药品（低库存预警列表）；");
        return List.of();
    }

    @Override
    public List<Drug> searchByName(String keyword) {
        System.out.println(" 4. 按药品名模糊查询药品及库存；");
        return List.of();
    }

    @Override
    public void validateQuantity(int quantity) {
        System.out.println("5. 输入数量<=0时给出提示。");
    }
}




