package com.soft.boot.config.model;

import com.soft.boot.config.util.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-14 14:13
 **/
@Data
@Validated
@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.yml"},factory = MixPropertySourceFactory.class)
@Component
public class User {
    private String name;
    private String age;
    @Valid
    private Book book;
    private String password;
}
