package com.crq.boot.orm.service.impl;

import com.crq.boot.orm.entity.Article;
import com.crq.boot.orm.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .id(1003)
                .author("crq")
                .title("Vue")
                .content("Vue从入门到精通")
                .build();
        Article article1 = articleService.saveArticle(article);
        assertNotNull(article1);
    }
}