package com.crq.boot.orm.service.impl;

import com.crq.boot.orm.dao.ArticleDao;
import com.crq.boot.orm.entity.Article;
import com.crq.boot.orm.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-18 09:20
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Article saveArticle(Article article) {
        int n = articleDao.save(article);
        if (n != 0) {
            return article;
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public List<Article> selectAll() {
        return articleDao.findAll();
    }

    @Override
    public Article findById(int id) {
        return null;
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return null;
    }
}
