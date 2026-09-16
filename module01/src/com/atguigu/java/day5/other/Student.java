package com.atguigu.java.day5.other;

/**
 * 实体类的创建规则：
 * 1、成员变量以前使用基本数据类型的全部都改成使用包装类型，目的是为了能够保存 null 值
 * 2、必须有无参构造器，为了确保无参构造器存在，一定要自己手动声明
 * 3、必须提供对外暴露的 getXxx()、setXxx() 方法
 *
 * 可选内容：
 * 1、toString() 方法
 * 2、有参构造器
 * 3、hashCode()、eqauls()方法
 */
public class Student {

    private Integer stuId;
    private String stuName;
    private Double stuSalary;
    private Boolean gender;

    public Student(Integer stuId, String stuName, Double stuSalary, Boolean gender) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSalary = stuSalary;
        this.gender = gender;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Double getStuSalary() {
        return stuSalary;
    }

    public void setStuSalary(Double stuSalary) {
        this.stuSalary = stuSalary;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
