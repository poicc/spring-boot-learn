package com.crq.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author crq
 * @TableName t_clazz
 */
@Data
@Alias("Clazz")
public class Clazz implements Serializable {
    /**
     * 班级id
     */
    private Integer clazzId;
    /**
     * 班级名称
     */
    private String clazzName;
    /**
     * 班级管理老师的id
     */
    private Integer teacherId;
    /**
     * 管理老师的id(一对一)
     */
    private Teacher teacher;
    /**
     * 班级里所有的学生，在一方中声明多方的集合
     */
    private List<Student> students;
    /**
     * 多方里声明一方的对象
     */
    private Clazz clazz;

    @Serial
    private static final long serialVersionUID = 1L;

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
        Clazz other = (Clazz) that;
        return (this.getClazzId() == null ? other.getClazzId() == null : this.getClazzId().equals(other.getClazzId()))
            && (this.getClazzName() == null ? other.getClazzName() == null : this.getClazzName().equals(other.getClazzName()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClazzId() == null) ? 0 : getClazzId().hashCode());
        result = prime * result + ((getClazzName() == null) ? 0 : getClazzName().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clazzId=").append(clazzId);
        sb.append(", clazzName=").append(clazzName);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}