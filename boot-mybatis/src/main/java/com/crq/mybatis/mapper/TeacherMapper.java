package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
* @author crq
 * @Entity generator.domain.Teacher
*/
@Mapper
public interface TeacherMapper  {

    /**
     * 根据教师id查询教师信息
     * @param teacherId teacherId
     * @return teacher
     */
    Teacher findOneByOne(int teacherId);

}
