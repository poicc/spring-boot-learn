package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class CourseMapperTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    void getCourse() {
        Course course = courseMapper.getCourse(20001);
        log.info(course.getCourseName()+ "," + course.getCourseId());
        course.getStudents().forEach(student -> log.info(String.valueOf(student)));
    }
}