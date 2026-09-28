package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
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

    @TableField(exist = false)
    private String depName;

    @TableLogic          // 逻辑删除字段
    private Integer is_deleted;

    @Version                     // 乐观锁版本号字段
    private Integer version;
}
