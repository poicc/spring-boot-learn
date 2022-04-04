package com.crq.boot.repository;


import com.crq.boot.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-01 12:37
 **/
@RepositoryRestResource(path="articles")
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    /**
     * 根据作者查询
     * @param author author
     * @return article
     */
    Article findByAuthor(String author);
}
