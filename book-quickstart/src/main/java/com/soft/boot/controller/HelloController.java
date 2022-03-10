package com.soft.boot.controller;

import com.soft.crq.service.MD5Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: HelloController
 * @author: crq
 * @create: 2022-03-07 14:55
 **/
@RestController
public class HelloController {
    @Resource
    private MD5Service md5Service;

    @GetMapping("/hello")
    public String getHello () {
        return "hello spring";
    }

    @GetMapping("/md5")
    public String getMd5() {
        return "自制starter测试：" +md5Service.getMD5("123456");
    }
}
