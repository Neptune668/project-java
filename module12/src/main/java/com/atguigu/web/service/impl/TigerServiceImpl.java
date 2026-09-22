package com.atguigu.web.service.impl;

import com.atguigu.web.dao.api.TigerDao;
import com.atguigu.web.service.api.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TigerServiceImpl implements TigerService {
    @Autowired
    private TigerDao tigerDao;

    @Override
    public void getTigerById() {
        tigerDao.getTigerById();
    }
}
