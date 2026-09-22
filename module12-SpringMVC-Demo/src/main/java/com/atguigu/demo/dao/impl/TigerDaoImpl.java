package com.atguigu.demo.dao.impl;

import com.atguigu.demo.dao.api.TigerDao;
import com.atguigu.demo.entity.Tiger;
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
    public List<Tiger> selectTigerList() {

        String sql = "select tiger_id tigerId, tiger_name tigerName, tiger_age tigerAge, tiger_salary tigerSalary from t_tiger";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Tiger.class));
    }

    @Override
    public void deleteTigerById(Integer tigerId) {
        String sql = "delete from t_tiger where tiger_id=?";
        jdbcTemplate.update(sql, tigerId);
    }

    @Override
    public void insertTiger(Tiger tiger) {
        String sql = "insert into t_tiger(tiger_name, tiger_age, tiger_salary) values(?,?,?)";
        jdbcTemplate.update(sql, tiger.getTigerName(), tiger.getTigerAge(), tiger.getTigerSalary());
    }

    @Override
    public Tiger selectTigerById(Integer tigerId) {
        String sql = "select tiger_id tigerId, tiger_name tigerName, tiger_age tigerAge, tiger_salary tigerSalary from t_tiger where tiger_id=?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Tiger.class), tigerId);
    }

    @Override
    public void updateTiger(Tiger tiger) {
        String sql = "update t_tiger set tiger_name=?, tiger_age=?, tiger_salary=? where tiger_id=?";

        jdbcTemplate.update(sql, tiger.getTigerName(), tiger.getTigerAge(), tiger.getTigerSalary(), tiger.getTigerId());
    }
}
