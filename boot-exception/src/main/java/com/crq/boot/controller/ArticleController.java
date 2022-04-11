package com.crq.boot.controller;


import com.crq.boot.entity.Article;
import com.crq.boot.service.ArticleService;
import com.crq.boot.utils.AjaxResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 11:44
 **/
@RestController
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/test/{id}")
    public AjaxResponse test(@PathVariable("id") int id) {
        if (id == 0) {
            articleService.systemBizError();
        }
        articleService.userBizError(id);
        Article article = Article.builder()
                .id(10)
                .title("SpringBoot从入门到精通")
                .build();
        return AjaxResponse.success(article);
    }


    @PostMapping("/articles")
    public Article saveArticle(@Valid @RequestBody Article article) {
        return article;
    }


}