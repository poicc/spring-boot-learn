package com.soft.boot.restful.controller;

import com.soft.boot.restful.common.AjaxResponse;
import com.soft.boot.restful.model.Article;
import com.soft.boot.restful.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @description: ArticleController
 * @author: crq
 * @create: 2022-03-10 16:29
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ArticleController {

    /**
     * 获取一篇Article，使用GET方法,根据id查询一篇文章
     *
     * @param id id
     * @return AjaxResponse
     */
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
//        Reader[] readers = {
//                Reader.builder().name("aaa").age(12).build(),
//                Reader.builder().name("aaa").age(12).build(),
//        };
        List<Reader> readers1 = List.of(Reader.builder().name("aaa").age(12).build(), Reader.builder().name("aaa").age(12).build());
        Article article = Article.builder().id(id).author("陈蓉琪").readerList(readers1).content("SpringBoot 从青铜到王者").title("SpringBoot").crateTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    @GetMapping()
    public AjaxResponse getArticleById(@RequestParam("id") Long id) {
//        Reader[] readers = {
//                Reader.builder().name("aaa").age(12).build(),
//                Reader.builder().name("aaa").age(12).build(),
//        };
        List<Reader> readers1 = List.of(Reader.builder().name("aaa").age(12).build(), Reader.builder().name("aaa").age(12).build());
        Article article = Article.builder().id(id).author("陈蓉琪").readerList(readers1).content("SpringBoot 从青铜到王者").title("SpringBoot").crateTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }




    /**
     * 增加一篇Article ，使用POST方法(RequestParam方式接收参数
     *
     * @param author     author
     * @param title      title
     * @param content    content
     * @param createTime createTime
     * @return AjaxResponse
     */
    @PostMapping("/param")
    public AjaxResponse saveArticle(@RequestParam(value = "author",defaultValue = "crq",required = false) String author,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam Date createTime) {
        log.info("saveArticle:" + author);
        log.info("saveArticle:" + title);
        log.info("saveArticle:" + content);
        log.info("saveArticle:" + createTime);
        return AjaxResponse.success();
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param article article
     * @return AjaxResponse
     */
    @PostMapping("/articles/body")
    public AjaxResponse addArticle(@RequestBody Article article) {
        log.info("addArticle:" + article);
        return AjaxResponse.success(article);
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param article article
     * @return AjaxResponse
     */
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            log.error("没有id");
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id id
     * @return AjaxResponse
     */
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
}
