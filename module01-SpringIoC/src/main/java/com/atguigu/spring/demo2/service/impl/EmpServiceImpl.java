package com.atguigu.spring.demo2.service.impl;

import com.atguigu.spring.demo2.dao.api.EmpDao;
import com.atguigu.spring.demo2.service.api.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public String save() {
        String save = empDao.save();

        return "hello ,i'm service" + save;
    }
}
