package com.atguigu.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpCondition {

    // 前端发送的查询条件数据：
    // empNo 精确查询（eq）
    private String empNo;

    // deptId 精确查询（eq）
    private Integer deptId;

    // empBirthday 范围查询（between）
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthdayBegin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthdayEnd;

    // empName 模糊查询（like）
    private String empName;

    // empSalary 范围查询（between）
    private Double empSalaryMin;

    private Double empSalaryMax;

    // phoneNum 精确查询（eq）
    private String phoneNum;

    // 分页还需要当前页页码和页容量
    private Integer pageNum = 1;
    private Integer pageSize = 5;

}
