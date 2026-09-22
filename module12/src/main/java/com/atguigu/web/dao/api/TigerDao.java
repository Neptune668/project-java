package com.atguigu.web.dao.api;

import com.atguigu.web.entity.Tiger;

import java.util.List;

public interface TigerDao {
    Tiger selectTigerById(Integer integer);

    List<Tiger> selectTigerList();

    void deleteTigerById(Integer tigerId);

    void insertTiger(Tiger tiger);

    void updateTiger(Tiger tiger);
}
