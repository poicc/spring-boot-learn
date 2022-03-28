package com.crq.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-28 11:38
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.com.crq.mybatis.mapper"})
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class,args);
    }
}
