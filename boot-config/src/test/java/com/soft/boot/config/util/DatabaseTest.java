package com.soft.boot.config.util;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-15 21:13
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void getPass() {
        String password = encryptor.encrypt("crq123456");
        System.out.println("database password: " + password);
        assertTrue(password.length() > 0);
    }
}
