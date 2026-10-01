package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Orders;
import com.atguigu.mp.service.OrdersService;
import com.atguigu.mp.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2026-10-01 16:11:56
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




