package com.crq.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-18 08:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    private Integer id;

    private String author;

    private String title;
}
