package com.atguigu.tx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;      // 员工ID（主键，自增）
    private String empNo;       // 员工编号
    private String empName;     // 员工姓名
    private Double empSalary;   // 员工工资
    private LocalDate empBirthday;   // 出生日期
    private String phoneNum;    // 手机号
    private Integer deptId;     // 部门ID

}
