package com.atguigu.web.dao.impl;

import com.atguigu.web.dao.api.TigerDao;
import com.atguigu.web.entity.Tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TigerDaoImpl implements TigerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Tiger selectTigerById(Integer tigerId) {
        String sql = "select * from t_tiger where tiger_id=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Tiger.class), tigerId);
    }

    @Override
    public List<Tiger> selectTigerList() {
        String sql = "select * from t_tiger";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tiger.class));
    }

    @Override
    public void deleteTigerById(Integer tigerId) {
        String sql = "delete from t_tiger where tiger_id=?";
        jdbcTemplate.update(sql, tigerId);
    }

    @Override
    public void insertTiger(Tiger tiger) {
        String sql = "insert into t_tiger(tiger_name,tiger_age,tiger_salary) values(?,?,?)";
        jdbcTemplate.update(sql, tiger.getTigerName(), tiger.getTigerAge(), tiger.getTigerSalary());
    }

    @Override
    public void updateTiger(Tiger tiger) {
        System.out.println("=============>"+tiger.getTigerId());
        String sql = "update t_tiger set tiger_name=?,tiger_age=?,tiger_salary=? where tiger_id=?";
        System.out.println(sql);
        int updated = jdbcTemplate.update(sql, tiger.getTigerName(), tiger.getTigerAge(), tiger.getTigerSalary(), tiger.getTigerId());
        System.out.println("=============>"+updated);
    }
}
