package com.atguigu.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName logistics_traces
 */
@TableName(value ="logistics_traces")
@Data
public class LogisticsTraces {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long logisticsRecordId;

    /**
     * 
     */
    private Date traceTime;

    /**
     * 
     */
    private String traceDesc;

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
        LogisticsTraces other = (LogisticsTraces) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLogisticsRecordId() == null ? other.getLogisticsRecordId() == null : this.getLogisticsRecordId().equals(other.getLogisticsRecordId()))
            && (this.getTraceTime() == null ? other.getTraceTime() == null : this.getTraceTime().equals(other.getTraceTime()))
            && (this.getTraceDesc() == null ? other.getTraceDesc() == null : this.getTraceDesc().equals(other.getTraceDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLogisticsRecordId() == null) ? 0 : getLogisticsRecordId().hashCode());
        result = prime * result + ((getTraceTime() == null) ? 0 : getTraceTime().hashCode());
        result = prime * result + ((getTraceDesc() == null) ? 0 : getTraceDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logisticsRecordId=").append(logisticsRecordId);
        sb.append(", traceTime=").append(traceTime);
        sb.append(", traceDesc=").append(traceDesc);
        sb.append("]");
        return sb.toString();
    }
}