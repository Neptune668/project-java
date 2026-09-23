package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_emp")   // 指定实体类对应的数据库表名
public class Employee {
    @TableId(type = IdType.AUTO)   // 主键，数据库自增
    private Integer empId;

    private String empNo;

    private String empName;

    private BigDecimal empSalary;

    private Date empBirthday;

    private String phoneNum;

    private Integer deptId;

}
