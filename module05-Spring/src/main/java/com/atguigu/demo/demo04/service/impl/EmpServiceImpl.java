package com.atguigu.demo.demo04.service.impl;

import com.atguigu.demo.demo04.dao.api.EmpDao;
import com.atguigu.demo.demo04.service.app.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    public String getHelloData() {

        String helloData = empDao.getHelloData();

        return "[Apple Service Data]" + helloData;
    }
}
