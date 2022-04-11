package com.crq.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-08 09:17
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloTest(){
        return "Hello";
    }
}