package com.atguigu.demo.dao.api;

import com.atguigu.demo.entity.Tiger;

import java.util.List;

public interface TigerDao {
    List<Tiger> selectTigerList();

    void deleteTigerById(Integer tigerId);

    void insertTiger(Tiger tiger);

    Tiger selectTigerById(Integer tigerId);

    void updateTiger(Tiger tiger);
}
