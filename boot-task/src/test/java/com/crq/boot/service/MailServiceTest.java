package com.crq.boot.service;

import com.crq.boot.entity.Article;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Resource
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Test
    public void testMail() {
        mailService.sendSimpleMail("1379336177@qq.com", "陈蓉琪", "陈蓉琪");
    }

    @Test
    public void sendHtml() throws MessagingException {
        mailService.sendHtmlMail("2560507398@qq.com", "一封HTML测试邮件", """
                <body><div>芜湖</div></body>
                """);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String filePath = "D:\\1\\img\\1.jpg";
        mailService.sendAttachmentsMail("2560507398@qq.com", "这是一封带附件的邮箱", "邮件中有附件", filePath);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        //添加动态数据，替换模板里面的占位符
        List<Article> articles = new ArrayList<>();
        articles.add(new Article(1L, "crq", "SpringBoot", "内容一", new Date()));
        articles.add(new Article(2L, "crq", "Vue.js", "内容二", new Date()));
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("freemarker-temp.ftl");
        //将模板文件及数据渲染完成之后，转换为html字符串
        Map<String, Object> model = new HashMap<>();
        model.put("articles", articles);
        String templateHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        //发送邮件
        mailService.sendHtmlMail("2560507398@qq.com", "这是一封freemarker模板的html测试邮件", templateHtml);
    }

    @Test
    public void sendResourceMail() throws MessagingException {
        String rscId="crq";
        String content="<html><body>这是有图片的邮件<br/><img src='cid:"+rscId+"' ></body></html>";
        String imgPath="D:/1/img/1.jpg";
        mailService.sendResourceMail("2560507398@qq.com","这邮件中含有图片",content,imgPath,rscId);
    }

}



