package com.soft.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloController
 * @author: crq
 * @create: 2022-03-07 14:55
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String getHello () {
        return "hello world";
    }
}
