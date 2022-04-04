package com.crq.boot.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @description: 注册拦截器
 * @author: crq
 * @create: 2022-04-04 11:43
 **/
@Configuration
//extends WebMvcConfigurerAdapter已弃用
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    private final String[] excludePath = {"/static"};
    @Resource
    private CustomHandlerInterceptor customHandlerInterceptor;

    @Resource
    private AccessLogInterceptor accessLogInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器 拦截规则
        //多个拦截器时 依次添加 执行顺序按添加顺序
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
        registry.addInterceptor(accessLogInterceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
