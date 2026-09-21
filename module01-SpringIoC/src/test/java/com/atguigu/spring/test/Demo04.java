package com.atguigu.spring.test;

import com.atguigu.spring.demo4.Demo;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class Demo04 {
    @Autowired
    private Demo demo;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private QueryRunner queryRunner;
    @Test
    public void test01(){
        DataSource druidDataSource = demo.getDruidDataSource();
        DataSource druidDataSource2 = demo.getDruidDataSource();
        System.out.println("druidDataSource = " + druidDataSource);
        System.out.println("druidDataSource2 = " + druidDataSource2);
    }
    @Test
    public void test02() throws SQLException {
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
        System.out.println("dataSource.getConnection() = " + dataSource.getConnection());
    }
    @Test
    public void test03() throws SQLException {
        System.out.println("queryRunner.getDataSource() = " + queryRunner.getDataSource());
        System.out.println("queryRunner.getDataSource() = " + queryRunner.getDataSource());

    }

}
