package com.crq.boot.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 13:10
 **/
@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private String avatar;
}
