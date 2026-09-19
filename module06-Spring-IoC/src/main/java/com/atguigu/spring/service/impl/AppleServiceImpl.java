package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.api.AppleDao;
import com.atguigu.spring.service.api.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppleServiceImpl implements AppleService {

    @Autowired
    private AppleDao appleDao;

    @Override
    public String getHelloData() {

        String helloData = appleDao.getHelloData();

        return "[Apple Service Data]" + helloData;
    }
}
