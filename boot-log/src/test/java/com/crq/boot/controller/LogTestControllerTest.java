package com.crq.boot.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class LogTestControllerTest {
    private static  final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @Test
    public void contextLoads() {
        logger.info("数据库日志info");
        logger.error("数据库日志error");
    }

}