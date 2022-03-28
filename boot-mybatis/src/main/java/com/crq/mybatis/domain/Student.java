package com.crq.mybatis.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author crq
 * @TableName t_student
 */
@Data
@Alias("Student")
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生所属班级的id
     */
    private Integer clazzId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生籍贯
     */
    private String hometown;

    /**
     * 出生日期
     */
    private Date birthday;

    private Clazz clazz;

    private List<Course> courses;

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
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getClazzId() == null ? other.getClazzId() == null : this.getClazzId().equals(other.getClazzId()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getHometown() == null ? other.getHometown() == null : this.getHometown().equals(other.getHometown()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getClazzId() == null) ? 0 : getClazzId().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getHometown() == null) ? 0 : getHometown().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", clazzId=").append(clazzId);
        sb.append(", studentName=").append(studentName);
        sb.append(", hometown=").append(hometown);
        sb.append(", birthday=").append(birthday);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}