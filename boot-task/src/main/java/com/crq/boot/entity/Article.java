package com.crq.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 12:43
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private Long id;
    private String author;
    private String title;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
}