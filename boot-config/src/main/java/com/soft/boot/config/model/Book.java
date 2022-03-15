package com.soft.boot.config.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @description: 书本
 * @author: crq
 * @create: 2022-03-14 14:14
 **/
@Data
public class Book {
    @NotNull
    private String name;
    @Min(value = 2, message = "价格不能小于1块")
    private Integer price;
    @Past
    private Date createTime;
//    @AssertTrue
//    private boolean isEnabled;
}
