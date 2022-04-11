package com.crq.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 11:10
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Article {
    @Min(5)
    private Integer id;
    @NotNull(message = "文章标题不能为空")
    private String title;
}