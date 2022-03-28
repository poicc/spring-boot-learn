package com.crq.mybatis.mapper;

import com.crq.mybatis.domain.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class TeacherMapperTest {
    @Resource
    private TeacherMapper teacherMapper;

    @Test
    void findOneByOne() {
        Teacher oneByOne = teacherMapper.findOneByOne(1);
        log.info(String.valueOf(oneByOne));
    }
}