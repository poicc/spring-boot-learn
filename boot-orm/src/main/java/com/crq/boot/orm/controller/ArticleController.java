package com.crq.boot.orm.controller;

import com.crq.boot.orm.common.AjaxResponse;
import com.crq.boot.orm.entity.Article;
import com.crq.boot.orm.service.impl.ArticleJpaServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-18 09:31
 **/
@RestController
@RequestMapping(value="/api/v1/articles")
public class ArticleController {

    @Resource
    private ArticleJpaServiceImpl articleJpaService;

    @GetMapping(value = "/all")
    public AjaxResponse selectAll(){
        return AjaxResponse.success(articleJpaService.selectAll());
    }

    @PostMapping(value = "/add")
    public AjaxResponse addArticle(@RequestBody Article article){
        return AjaxResponse.success(articleJpaService.saveArticle(article));
    }
    @PutMapping
    public AjaxResponse updateArticle(@RequestBody Article article){
        if (articleJpaService.saveArticle(article)!=null) {
            return AjaxResponse.success("修改成功");
        }else {
            return null;
        }
    }
    @GetMapping("{id}")
    public AjaxResponse findById(@PathVariable int id){
        return AjaxResponse.success(articleJpaService.findById(id));
    }
}
