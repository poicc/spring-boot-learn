package com.crq.boot.controller;

import com.crq.boot.utils.MathCodeUtil;
import com.crq.boot.utils.RandomCodeUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: crq
 * @create: 2022-04-29 09:32
 **/
@RestController
@Slf4j
public class ValidateCodeController {
    @Resource
    private RandomCodeUtil randomCodeUtil;
    @Resource
    private MathCodeUtil mathCodeUtil;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;
    @Resource
    private Producer producer;


    @GetMapping("/randomCode")
    private void randomCode() {
        try {
            randomCodeUtil.createCode(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/checkRandomCode")
    private String checkRandomCode(String code) {
        String saveCode = (String) request.getSession().getAttribute("randomCode");
        log.info("randomCode");
        if (saveCode.equalsIgnoreCase(code)) {
            log.info("验证码正确");
            return "验证码正确";
        } else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }

    @GetMapping("/mathCode")
    private void mathCode() {
        try {
            mathCodeUtil.createCode(request, response);
        } catch (IOException e) {
            log.error("生成验证码错误");
        }

    }

    @GetMapping("/checkMathCode")
    private String checkMathCode(String code) {
        int saveCode = (Integer) request.getSession().getAttribute("mathCode");
        log.info(String.valueOf(saveCode));
        int sendCode = Integer.parseInt(code);
        if (saveCode == sendCode) {
            log.info("验证码正确");
            return "验证码正确";
        } else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }


    @GetMapping("/captchCode")
    private void captchCode() {
        response.setHeader("Cache-Control", "no-store");
        response.setContentType("image/jpeg");
        //    文字验证码
        String text = producer.createText();
        log.info(text);
        request.getSession().setAttribute("captchCode", text);
        //    图片验证码
        BufferedImage image = producer.createImage(text);
        //    保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY, text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(outputStream);
    }


    @GetMapping("/checkCapchaCode")
    private String checkCapchaCode(String code) {
        String saveCode = (String) request.getSession().getAttribute("captchCode");
        log.info(saveCode);
        if (saveCode.equalsIgnoreCase(code)) {
            log.info("验证码正确");
            return "验证码正确";
        } else {
            log.info("验证码错误");
            return "验证码错误";
        }
    }
}