package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info(String.valueOf(student));
    }


}