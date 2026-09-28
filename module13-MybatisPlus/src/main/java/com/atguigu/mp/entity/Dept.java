package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_dept")
public class Dept {

    @TableId(type = IdType.AUTO)
    private Integer deptId;

    private String deptName;

    @TableField(exist = false)          // 员工列表：表中没有对应列，仅用于组装
    private List<Employee> empList;

}