package com.soft.boot.config.model;

import com.soft.boot.config.util.MixPropertySourceFactory;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @description: 家庭 成员变量名要跟Yml配置项的key保持一致
 * @author: crq
 * @create: 2022-03-14 11:08
 **/
@Data
@Component
@ConfigurationProperties(prefix = "family") //配置整理前缀
@PropertySource(value = {"classpath:family.yml"},factory = MixPropertySourceFactory.class)
//@PropertySource(value = {"classpath:family.properties"})
@Validated
public class Family {
    @Length(min = 5, max = 20, message = "家庭名称长度必须在5-20位之间")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
