package com.crq.boot.task;

import org.springframework.stereotype.Component;

/**
 * @description: 同步任务
 * @author: crq
 * @create: 2022-04-12 15:27
 **/
@Component
public class SyncTask extends AbstractTask {

    @Override
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Override
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
