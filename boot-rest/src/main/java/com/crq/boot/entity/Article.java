package com.crq.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-18 08:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Article {
    private static final long serialVersionUID=-263184727215494114L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private String thumbnail;
    private String content;

    @Column(name="create_time",updatable = false)
    private Date createTime;
    @Column(name="update_time",updatable = false)
    private Date updateTime;
}
