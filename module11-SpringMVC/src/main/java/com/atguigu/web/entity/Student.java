package com.atguigu.web.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {

    private Integer stuId;
    private String stuName;
    private Double stuSalary;

    private School school;

    private List<Subject> subjectList;

}
