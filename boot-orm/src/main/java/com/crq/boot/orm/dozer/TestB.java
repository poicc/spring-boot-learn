package com.crq.boot.orm.dozer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-28 11:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestB {
    private String name;
    private Date createTime;
}
