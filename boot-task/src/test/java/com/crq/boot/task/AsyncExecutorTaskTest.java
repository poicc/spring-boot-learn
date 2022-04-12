package com.crq.boot.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AsyncExecutorTaskTest {
    @Resource
    private AsyncExecutorTask asyncExecutorTask;

    @Test
    public void testAsyncExecutorTask() throws Exception {
        asyncExecutorTask.doTaskOneCallback();
        asyncExecutorTask.doTaskTwoCallback();
        asyncExecutorTask.doTaskThreeCallback();
    }

}