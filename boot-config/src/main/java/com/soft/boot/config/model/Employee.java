package com.soft.boot.config.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @description: @Configuration注解 标识本类一个配置类
 * @author: crq
 * @create: 2022-03-14 15:40
 **/
@Data
@Configuration
@PropertySource(name = "employeeProperties", value = "classpath:employee.properties")
public class Employee {

    /**
     * 使用SpEL读取employee.properties 只能一个个注入
     */
    @Value("#{'${employee.name}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.name}'.split(',')[0]}")
    private String firstName;

    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value("#{${employee.age}['four'] != null ? ${employee.age}['four'] : 80}")
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
