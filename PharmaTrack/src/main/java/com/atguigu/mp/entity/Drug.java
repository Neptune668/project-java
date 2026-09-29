package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品表
 * @TableName t_drug
 */
@TableName(value ="t_drug")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug {
    /**
     * 药品ID
     */
    @TableId(type = IdType.AUTO)
    private Integer drugId;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 预警阈值
     */
    private Integer warnLine;

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
        Drug other = (Drug) that;
        return (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()))
            && (this.getDrugName() == null ? other.getDrugName() == null : this.getDrugName().equals(other.getDrugName()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getWarnLine() == null ? other.getWarnLine() == null : this.getWarnLine().equals(other.getWarnLine()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        result = prime * result + ((getDrugName() == null) ? 0 : getDrugName().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getWarnLine() == null) ? 0 : getWarnLine().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugId=").append(drugId);
        sb.append(", drugName=").append(drugName);
        sb.append(", stock=").append(stock);
        sb.append(", warnLine=").append(warnLine);
        sb.append("]");
        return sb.toString();
    }
}