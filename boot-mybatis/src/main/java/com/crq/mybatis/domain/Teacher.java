package com.crq.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;

/**
 * 
 * @author crq
 * @TableName t_teacher
 */
@Data
@Alias("Teacher")
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师管理的班级id
     */
    private Integer clazzId;

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
        Teacher other = (Teacher) that;
        return (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getClazzId() == null ? other.getClazzId() == null : this.getClazzId().equals(other.getClazzId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getClazzId() == null) ? 0 : getClazzId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", clazzId=").append(clazzId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}