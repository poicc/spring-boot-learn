package com.crq.boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @description: 文章实体
 * @author: crq
 * @create: 2022-03-10 16:27
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"content","title"})
public class Article {
    @JsonIgnore
    private Long id;

//    @JsonProperty("writer")
    private String author;
    private String content;
    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date crateTime;
    private List<Reader> readerList;
//    private Date updateTime;
}
