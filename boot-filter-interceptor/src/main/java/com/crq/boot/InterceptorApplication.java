package com.crq.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 10:19
 **/
@SpringBootApplication
//@ServletComponentScan
public class InterceptorApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterceptorApplication.class,args);
        //获取ConfigurableApplicationContext上下文
//        ConfigurableApplicationContext context =  SpringApplication.run(InterceptorApplication.class,args);
//        //装载监听
//        context.addApplicationListener(new MyListener1());
//        //发布事件
//        context.publishEvent(new MyEvent("测试事件"));
    }
}
