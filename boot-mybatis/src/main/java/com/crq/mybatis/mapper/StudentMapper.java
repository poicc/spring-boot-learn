package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 批量新增
     * @param students students
     * @return int
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     * @param ids ids
     * @return int
     */
    int batchDelete(@Param("ids") List<Integer> ids);

    /**
     * 批量修改
     * @param students students
     * @return int
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 动态查询
     * @param student student
     * @return List<Student>
     */
    List<Student> findStudentBy(@Param("student") Student student);

}
