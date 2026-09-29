package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_emp
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="t_emp")
@Data
public class Emp {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer empId;

    /**
     * 
     */
    private String empNo;

    /**
     * 
     */
    private String empName;

    /**
     * 
     */
    private Double empSalary;

    /**
     * 
     */
    private Date empBirthday;

    /**
     * 
     */
    private String phoneNum;

    /**
     * 
     */
    private Integer deptId;

    /**
     * 0未删除 1已删除
     */
    private Integer isDeleted;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    @TableField(exist = false)
    private Dept dept;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Emp other = (Emp) that;
        return (this.getEmpId() == null ? other.getEmpId() == null : this.getEmpId().equals(other.getEmpId()))
            && (this.getEmpNo() == null ? other.getEmpNo() == null : this.getEmpNo().equals(other.getEmpNo()))
            && (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
            && (this.getEmpSalary() == null ? other.getEmpSalary() == null : this.getEmpSalary().equals(other.getEmpSalary()))
            && (this.getEmpBirthday() == null ? other.getEmpBirthday() == null : this.getEmpBirthday().equals(other.getEmpBirthday()))
            && (this.getPhoneNum() == null ? other.getPhoneNum() == null : this.getPhoneNum().equals(other.getPhoneNum()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEmpId() == null) ? 0 : getEmpId().hashCode());
        result = prime * result + ((getEmpNo() == null) ? 0 : getEmpNo().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getEmpSalary() == null) ? 0 : getEmpSalary().hashCode());
        result = prime * result + ((getEmpBirthday() == null) ? 0 : getEmpBirthday().hashCode());
        result = prime * result + ((getPhoneNum() == null) ? 0 : getPhoneNum().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empId=").append(empId);
        sb.append(", empNo=").append(empNo);
        sb.append(", empName=").append(empName);
        sb.append(", empSalary=").append(empSalary);
        sb.append(", empBirthday=").append(empBirthday);
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", deptId=").append(deptId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", version=").append(version);
        sb.append("]");
        return sb.toString();
    }
}