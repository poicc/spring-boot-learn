package com.crq.boot.orm.dao;

import com.crq.boot.orm.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleDaoTest {
    @Resource
    private ArticleDao articleDao;

    @Test
    void save() {
        Article article = Article.builder()
                .id(1001)
                .author("crq")
                .title("SpringBoot")
                .content("SpringBoot从入门到精通")
                .createTime(new Date())
                .build();
        int rows = articleDao.save(article);
        assertEquals(1,rows);
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void findById() {
        Article article = articleDao.findById(1001);
        System.out.println(article);
    }

    @Test
    void findAll() {
    }
}