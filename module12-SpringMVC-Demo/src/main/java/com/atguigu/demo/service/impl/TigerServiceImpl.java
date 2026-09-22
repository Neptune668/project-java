package com.atguigu.demo.service.impl;

import com.atguigu.demo.dao.api.TigerDao;
import com.atguigu.demo.entity.Tiger;
import com.atguigu.demo.service.api.TigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TigerServiceImpl implements TigerService {

    @Autowired
    private TigerDao tigerDao;

    @Override
    public List<Tiger> getTigerList() {
        return tigerDao.selectTigerList();
    }

    @Override
    @Transactional
    public void removeTigerById(Integer tigerId) {
        tigerDao.deleteTigerById(tigerId);
    }

    @Override
    @Transactional
    public void saveTiger(Tiger tiger) {
        tigerDao.insertTiger(tiger);
    }

    @Override
    public Tiger getTigerById(Integer tigerId) {
        return tigerDao.selectTigerById(tigerId);
    }

    @Override
    @Transactional
    public void updateTiger(Tiger tiger) {
        tigerDao.updateTiger(tiger);
    }
}
