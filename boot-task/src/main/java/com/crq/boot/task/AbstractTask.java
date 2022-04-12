package com.crq.boot.task;

import java.util.Random;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-12 15:24
 **/

public abstract class AbstractTask {
    private static final Random RANDOM = new Random();

    public void doTaskOne() throws Exception {
        System.out.println("开始任务一");
        long start = currentTimeMillis();
        sleep(RANDOM.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时："+(end-start)+"毫秒");
    }

    public void doTaskTwo() throws Exception {
        System.out.println("开始任务二");
        long start = currentTimeMillis();
        sleep(RANDOM.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时："+(end-start)+"毫秒");
    }

    public void doTaskThree() throws Exception {
        System.out.println("开始任务三");
        long start = currentTimeMillis();
        sleep(RANDOM.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时："+(end-start)+"毫秒");
    }
}
