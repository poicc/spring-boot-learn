package com.crq.boot.redis.dao;


import com.crq.boot.redis.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 09:08
 **/
public interface ArticleRepository extends JpaRepository<Article, Integer> {
        /**
         * 注意这个方法的名称，JPA会根据方法名自动生成SQL执行
         * 等同于：SELECT * FROM article WHERE author = ?
         *
         * @param author author
         * @return List<Article>
         */
        List<Article> findByAuthor(String author);
}
