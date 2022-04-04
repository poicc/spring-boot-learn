package com.crq.boot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 15:47
 **/
@Component
@Slf4j
public class CommandLineStartRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineStartRunner传入参数: {}", Arrays.toString(args));
    }
}
