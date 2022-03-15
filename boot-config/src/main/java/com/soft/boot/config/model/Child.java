package com.soft.boot.config.model;

import lombok.Data;

import java.util.List;

/**
 * @description: 孩子
 * @author: crq
 * @create: 2022-03-14 11:06
 **/
@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
