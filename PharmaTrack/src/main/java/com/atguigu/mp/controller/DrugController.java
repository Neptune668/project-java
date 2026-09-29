package com.atguigu.mp.controller;

import com.atguigu.mp.entity.Drug;
import com.atguigu.mp.entity.Result;
import com.atguigu.mp.service.DrugService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 药品管理
 */
@RequestMapping("/drug")
@RestController
@RequiredArgsConstructor
public class DrugController {
    @Autowired
    private DrugService drugService;

    /** 1. 入库：按药品名增加库存 */
    @PostMapping("/inbound")
    public Result<Void> inbound(@RequestParam String drugName,
                                @RequestParam Integer quantity) {
        if (drugName == null || drugName.trim().isEmpty()) {
            throw new RuntimeException("药品名不能为空");
        }
        if (quantity == null || quantity <= 0) {
            throw new RuntimeException("入库数量必须大于0");
        }
        drugService.increaseStock(drugName, quantity);
        return Result.success();
    }

    /** 2. 出库：校验库存充足后扣减，不足给出提示 */
    @PostMapping("/outbound")
    public Result<Void> outbound(@RequestParam String drugName,
                                 @RequestParam Integer quantity) {
        if (drugName == null || drugName.trim().isEmpty()) {
            throw new RuntimeException("药品名不能为空");
        }
        if (quantity == null || quantity <= 0) {
            throw new RuntimeException("出库数量必须大于0");
        }
        drugService.decreaseStock(drugName, quantity);
        return Result.success();
    }

    /** 3. 查询所有“库存 < 预警阈值”的药品 */
    @GetMapping("/low-stock")
    public Result<List<Drug>> lowStock() {
        List<Drug> list = drugService.lambdaQuery()
                .apply("stock < warn_line")
                .list();
        return Result.success(list);
    }

    /** 4. 按药品名模糊查询药品及库存 */
    @GetMapping("/search")
    public Result<List<Drug>> search(@RequestParam String name) {
        List<Drug> list = drugService.lambdaQuery()
                .like(StringUtils.hasText(name), Drug::getDrugName, name)
                .list();
        return Result.success(list);
    }

    /** 5. 输入数量 <= 0 时给出提示 */
    @PostMapping("/validate-quantity")
    public Result<Void> validateQuantity(@RequestParam Integer quantity) {
        drugService.validateQuantity(quantity);
        return Result.success();
    }
}
