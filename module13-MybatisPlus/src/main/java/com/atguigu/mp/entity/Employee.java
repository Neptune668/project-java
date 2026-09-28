package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Builder
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

    @TableField(value = "phone_num", select = false)
    private String phoneNumHappy;

    // 关联的部门对象：查询后手动填充，表中没有对应列
    @TableField(exist = false)
    private Dept dept;

    @TableField(exist = false)
    private List<SysRole> sysRoleList;

    private Integer deptId;

    @TableField(exist = false)
    private String deptName;

    // @TableLogic // 逻辑删除字段
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)          // 插入时自动填充
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)   // 插入和更新时都自动填充
    private LocalDateTime updateTime;

    @Version                     // 乐观锁版本号字段
    private Integer version;
}