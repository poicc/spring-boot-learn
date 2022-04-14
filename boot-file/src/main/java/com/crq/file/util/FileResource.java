package com.crq.file.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-14 22:14
 **/
@Data
@Component
@ConfigurationProperties(prefix = "file")
@PropertySource(value = {"classpath:file.properties"})
public class FileResource {
    private String endPoint;
    private String accessKey;
    private String secretKey;
}
