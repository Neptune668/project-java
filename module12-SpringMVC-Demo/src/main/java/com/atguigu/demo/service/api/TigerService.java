package com.atguigu.demo.service.api;

import com.atguigu.demo.entity.Tiger;

import java.util.List;

public interface TigerService {
    List<Tiger> getTigerList();

    void removeTigerById(Integer tigerId);

    void saveTiger(Tiger tiger);

    Tiger getTigerById(Integer tigerId);

    void updateTiger(Tiger tiger);
}
