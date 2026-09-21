package com.atguigu.spring.demo2.dao.impl;

import com.atguigu.spring.demo2.dao.api.EmpDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Override
    public String save() {
        return "保存信息到数据库";
    }
}
