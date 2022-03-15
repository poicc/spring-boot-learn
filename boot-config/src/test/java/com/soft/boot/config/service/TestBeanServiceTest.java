package com.soft.boot.config.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class TestBeanServiceTest {
//    注入Spring上下文环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    void textLoadService() {
        //从测试环境的Spring上下文中读取xml配置文件 得到testBeanService 有的话xml配置文件生效
        boolean flag = ioc.containsBean("testBeanService");
        assertTrue(flag);
        TestBeanService tbs = (TestBeanService) ioc.getBean("testBeanService");
        TestBeanService tbs1 = (TestBeanService) ioc.getBean("testBeanService1");
        log.info(tbs.getName());
        log.info(tbs1.getName());
        assertEquals("SpringBoot",tbs.getName());
        assertEquals("SpringBoot1",tbs1.getName());

    }
}
