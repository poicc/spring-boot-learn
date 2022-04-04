package com.crq.boot.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 14:25
 **/
@Data
public class AccessLog {
    private String username;
    private Integer duration;
    private String httpMethod;
    private Integer httpStatus;
    private String ip;
    private String url;
    private Date createTime;

    @Override
    public String toString() {
        return "AccessLog{" +
                "username='" + username + '\'' +
                ", duration=" + duration +
                ", httpMethod='" + httpMethod + '\'' +
                ", httpStatus=" + httpStatus +
                ", ip='" + ip + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
