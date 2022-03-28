package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
* @author crq
 * @Entity generator.domain.Student
*/
@Mapper
public interface StudentMapper {

    /**
     * 根据学生id查询学生
     * @param studentId studentId
     * @return student
     */
    Student findManyByOne(int studentId);

    /**
     * 根据学生id查询学生
     * @param studentId studentId
     * @return 学生信息 关联班级和课程
     */
    Student getStudent(int studentId);

}
