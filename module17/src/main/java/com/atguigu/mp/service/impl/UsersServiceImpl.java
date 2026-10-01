package com.atguigu.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.mp.entity.Users;
import com.atguigu.mp.service.UsersService;
import com.atguigu.mp.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author YuanYi
* @description 针对表【users】的数据库操作Service实现
* @createDate 2026-10-01 16:11:56
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




