package com.soft.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动主类
 * @author: crq
 * @create: 2022-03-14 10:55
 **/
@Slf4j
@SpringBootApplication
//@ImportResource(locations = {"classpath:beans.xml","classpath:bean.xml"})
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
        log.info("服务启动成功");
    }
}
