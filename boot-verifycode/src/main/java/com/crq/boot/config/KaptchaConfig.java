package com.crq.boot.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: crq
 * @create: 2022-04-29 09:57
 **/
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer(){
        Properties properties = new Properties();
        properties.put("kaptcha.barber","no");
        properties.put("kaptcha.textproducer.font.color","black");
        properties.put("kaptcha.textproducer.char.space","5");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}