package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.api.AppleDao;
import org.springframework.stereotype.Repository;

@Repository("atguigu_apple_dao")
public class AppleDaoImpl implements AppleDao {
    @Override
    public String getHelloData() {
        return "{Apple Dao Data}";
    }
}
