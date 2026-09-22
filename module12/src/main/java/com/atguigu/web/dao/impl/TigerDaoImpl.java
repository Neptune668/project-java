package com.atguigu.web.dao.impl;

import com.atguigu.web.dao.api.TigerDao;
import com.atguigu.web.entity.Tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TigerDaoImpl implements TigerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Tiger selectTigerById(Integer tigerId) {
        String sql = "select * from t_tiger where tiger_id=?;";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Tiger.class), tigerId);
    }
}
