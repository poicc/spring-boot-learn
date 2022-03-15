package com.soft.boot.config.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class) //junit5的写法
@Slf4j
//@RunWith(SpringRunner.class) junit4的写法
class EmployeeTest {
    @Autowired
    private Employee employee;

    @Test
    void valueBind() throws Exception {
        log.info(String.valueOf(employee));
//        for (Map.Entry<String, Integer> entry : employee.getEmployeeAge().entrySet()) {
//            log.info("name=" + entry.getKey() + ",value=" + entry.getValue());
//        }
        employee.getEmployeeAge().forEach((key, value) -> log.info("name=" + key + ",value=" + value));
//        Map<String, Integer> map = employee.getEmployeeAge();
//        map.forEach((key, value) -> log.info("name=" + key + ",value=" + value));
    }
}