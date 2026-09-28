package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("t_emp_role")
public class EmpRoleInner {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer empId;
    private Integer roleId;

}
