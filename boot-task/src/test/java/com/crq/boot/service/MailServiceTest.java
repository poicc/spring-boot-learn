package com.crq.boot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    public void testMail() {
        mailService.sendSimpleMail("1379336177@qq.com","陈蓉琪","陈蓉琪");
    }

    @Test
    public void sendHtml() throws MessagingException {
        mailService.sendHtmlMail("2560507398@qq.com","一封HTML测试邮件", """
                <body><div>芜湖</div></body>
                """);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        String filePath = "D:\\1\\img\\1.jpg";
        mailService.sendAttachmentsMail("2560507398@qq.com","这是一封带附件的邮箱","邮件中有附件",filePath);
    }

}