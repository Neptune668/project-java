package com.atguigu.web.service.api;

import com.atguigu.web.entity.Tiger;

import java.util.List;

public interface TigerService {
    Tiger getTigerById(Integer integer);

    List<Tiger> getTigerByList();

    void deleteTigerById(Integer tigerId);

    void addTiger(Tiger tiger);

    void updateTiger(Tiger tiger);
}
