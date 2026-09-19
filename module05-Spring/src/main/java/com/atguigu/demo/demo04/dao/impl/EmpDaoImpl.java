package com.atguigu.demo.demo04.dao.impl;

import com.atguigu.demo.demo04.dao.api.EmpDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public String getHelloData() {
        return "{Apple Dao Data}";
    }

}
