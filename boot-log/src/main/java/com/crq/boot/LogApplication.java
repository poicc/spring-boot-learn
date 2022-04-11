package com.crq.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 14:15
 **/
@SpringBootApplication
public class LogApplication {
    public static void main(String[] args) {
//        System.setProperty("Log4jContextSelector","org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(LogApplication.class,args);
    }
}
