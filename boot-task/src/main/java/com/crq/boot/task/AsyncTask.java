package com.crq.boot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description: 异步任务
 * @author: crq
 * @create: 2022-04-12 15:27
 **/
@Component
public class AsyncTask extends AbstractTask{

    /**
     * @Async 将同步方法变成异步方法
     * @throws Exception ex
     */
    @Override
    @Async
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Override
    @Async
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Override
    @Async
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
