package com.atguigu.mp.service;

import com.atguigu.mp.entity.Drug;
import com.baomidou.mybatisplus.spring.service.IService;

import java.util.List;

/**
 * @author YuanYi
 * @description 针对表【t_drug(药品表)】的数据库操作Service
 * @createDate 2026-09-29 18:46:34
 */
public interface DrugService extends IService<Drug> {


    /**
     * 1. 入库
     */
    void increaseStock(String drugName, int quantity);

    /**
     * 2. 出库
     */
    void decreaseStock(String drugName, int quantity);

    /**
     * 3. 低库存预警列表
     */
    List<Drug> listLowStock();

    /**
     * 4. 按药品名模糊查询
     */
    List<Drug> searchByName(String keyword);

    /**
     * 5. 数量校验
     */
    void validateQuantity(int quantity);

}
