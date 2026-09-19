package com.atguigu.proxy.test;

import com.atguigu.proxy.api.SoldierService;
import com.atguigu.proxy.impl.SoldierServiceImpl;
import com.atguigu.proxy.proxy.LogDynamicProxyFactory;
import org.junit.Test;

public class Demo02 {
    @Test
    public void test01() {
        SoldierServiceImpl service = new SoldierServiceImpl();
        SoldierService proxy = (SoldierService) new LogDynamicProxyFactory(service).getProxy();
        proxy.saveSoldier();
        proxy.removeSoldier();
        proxy.updateSoldier();
        proxy.querySoldier();
    }
}
