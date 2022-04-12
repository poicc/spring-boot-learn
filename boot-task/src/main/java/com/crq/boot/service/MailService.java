package com.crq.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-12 17:06
 **/
@Service
public class MailService {
    @Resource
    private JavaMailSender mailSender;

    @Value("2631315464@qq.com")
    private String fromEmail;


    /**
     * 发送文本邮件
     * @param to 收件人
     * @param subject 标题
     * @param content 内容
     */
    public void sendSimpleMail(String to,String subject,String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        //16422802@qq.com
    }

    /**
     * 发送HTML邮件
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        //注意这里使用的是MimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }

    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentsMail(String to, String subject, String content,String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(fromEmail);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        //添加附件资源
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
        helper.addAttachment(fileName,file);
        mailSender.send(message);

    }
}
