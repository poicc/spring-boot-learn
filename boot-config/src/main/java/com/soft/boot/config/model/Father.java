package com.soft.boot.config.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

/**
 * @description: 爸爸
 * @author: crq
 * @create: 2022-03-14 11:07
 **/
@Data
public class Father {
    private String name;
    @Min(value = 22, message = "爸爸年龄不小于22岁！！")
    private Integer age;
    @Email
    private String email;
}
