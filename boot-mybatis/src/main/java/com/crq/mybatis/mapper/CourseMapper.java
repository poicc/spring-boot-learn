package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Course;
import org.apache.ibatis.annotations.Mapper;

/**
* @author crq
 * @Entity generator.domain.Course
*/
@Mapper
public interface CourseMapper {

    /**
     * 查询课程及选修该课程的所有学生
     * @param courseId courseId
     * @return course
     */
    Course getCourse(int courseId);


}
