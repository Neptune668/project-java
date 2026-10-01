package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mp.entity.OrderItems;
import com.atguigu.mp.service.OrderItemsService;
import com.atguigu.mp.mapper.OrderItemsMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【order_items】的数据库操作Service实现
* @createDate 2026-10-01 16:11:56
*/
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems>
    implements OrderItemsService{

}




