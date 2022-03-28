package com.crq.boot.orm.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class TestBTest {

    @Test
    void BeanUtilsTest() {
        TestA testA = TestA.builder().name("zhangsan").build();
        TestB testB = new TestB();
        BeanUtils.copyProperties(testA,testB);
        log.info(String.valueOf(testB));
    }

    @Test
    void dozerTest1() {
        TestA testA = new TestA("zhangsan","2022-03-28 12:12:12");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        TestB testB = mapper.map(testA,TestB.class);
        log.info(String.valueOf(testB));
    }

    @Test
    void dozerTest2() {
        TestA testA = new TestA("zhangsan","2022-03-28 12:12:12");
        Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles("dozer/dozer-mapping.xml").build();
        TestB testB = mapper.map(testA,TestB.class);
        log.info(String.valueOf(testB));
    }

}