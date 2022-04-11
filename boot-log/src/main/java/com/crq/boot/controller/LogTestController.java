package com.crq.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 13:59
 **/
@RestController
@RequestMapping("/log")
public class LogTestController {

    private static  final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/test")
    public void test(){
        logger.trace("trace日志");
        logger.debug("debug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志");
    }
}