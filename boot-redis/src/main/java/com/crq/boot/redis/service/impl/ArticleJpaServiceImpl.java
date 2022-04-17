package com.crq.boot.redis.service.impl;


import com.crq.boot.redis.dao.ArticleRepository;
import com.crq.boot.redis.model.Article;
import com.crq.boot.redis.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 09:10
 **/
@Service
@Slf4j
public class ArticleJpaServiceImpl implements ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    public static final String CACHE_OBJECT = "article";
    public static final String CACHE_LIST_KEY = "\"list\"";


    @Override
    @Transactional(rollbackFor = {Exception.class})
    @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY)
    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    @Caching(evict = {
            @CacheEvict(value = CACHE_OBJECT,key = CACHE_LIST_KEY), //删除lst集合缓存
            @CacheEvict(value = CACHE_OBJECT,key = "#id") //删除单挑记录缓存
    }

    )
    public void deleteById(int id){
        articleRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateArticle(Article article){
        articleRepository.save(article);
    }

    @Override
    @Cacheable(value = CACHE_OBJECT,key = CACHE_LIST_KEY)
    public List<Article> selectAll() {
        return articleRepository.findAll();
    }

    @Override
    @Cacheable(value = CACHE_OBJECT,key = "#id")
    public Article findById(int id) {
        Optional<Article> optional = articleRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }
}

