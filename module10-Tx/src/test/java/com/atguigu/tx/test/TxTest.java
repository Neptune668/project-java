package com.atguigu.tx.test;

import com.atguigu.tx.service.api.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class TxTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmpService empService;

    @Test
    public void test01() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }

    @Test
    public void test02() {
        empService.updateTwice();
    }
}
