package com.crq.boot.controller;

import com.crq.boot.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 19:03
 **/
@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/freemarker")
    public String index(Model model) {
        List<Article> articleList = Arrays.asList(
                new Article(1, "张三", "JAVA"),
                new Article(2, "张三凤", "Spring"),
                new Article(3, "张三丰", "SpringBoot")
        );
        model.addAttribute("articles", articleList);
        System.out.println(articleList);
        //模板名称
        return "freemarker-demo";
    }

    @GetMapping("/thymeleaf")
    public String indexThymeleaf(Model model) {
        List<Article> articleList = Arrays.asList(
                new Article(1, "张三", "JAVA"),
                new Article(2, "张三凤", "Spring"),
                new Article(3, "张三丰", "SpringBoot")
        );
        model.addAttribute("articles", articleList);
        //模板名称
        return "thymeleaf-demo";
    }
}
