package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Products;
import com.atguigu.mp.service.ProductsService;
import com.atguigu.mp.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【products】的数据库操作Service实现
* @createDate 2026-10-01 16:11:56
*/
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products>
    implements ProductsService{

}




