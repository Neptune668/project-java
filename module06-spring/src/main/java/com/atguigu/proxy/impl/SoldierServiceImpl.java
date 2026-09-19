package com.atguigu.proxy.impl;

import com.atguigu.proxy.api.SoldierService;

public class SoldierServiceImpl implements SoldierService {


    @Override
    public void saveSoldier() {
        System.out.println("[方法内部][执行士兵信息保存……]");
    }

    @Override
    public void removeSoldier() {
        System.out.println("[方法内部][执行士兵信息删除……]");
    }

    @Override
    public void updateSoldier() {
        System.out.println("[方法内部][执行士兵信息更新……]");
    }

    @Override
    public void querySoldier() {
        System.out.println("[方法内部][执行士兵信息查询……]");
    }
}
