package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_emp")
public class Employee {
    @TableId(type = IdType.AUTO)   // 主键，数据库自增
    private Integer empId;

    private String empNo;

    private String empName;

    private BigDecimal empSalary;

    private Date empBirthday;

    @TableField(value = "phone_num")
    private String phoneNum66;

    private Integer deptId;
}
