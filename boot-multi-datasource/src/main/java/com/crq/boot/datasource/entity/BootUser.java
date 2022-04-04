package com.crq.boot.datasource.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-01 10:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BootUser {
    private Integer id;
    private String name;
    private String detail;
}
