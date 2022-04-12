package com.crq.boot.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-12 20:35
 **/
public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        System.out.println("quartz简单的定时任务执⾏时间：" + new Date());
    }
}
