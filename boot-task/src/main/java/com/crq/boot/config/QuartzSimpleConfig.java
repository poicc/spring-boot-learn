package com.crq.boot.config;

import com.crq.boot.task.QuartzSimpleTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 定时调度
 * @author: crq
 * @create: 2022-04-12 20:36
 **/
@Configuration
public class QuartzSimpleConfig {
    /**
     * 指定具体的定时任务类
     *
     * @return JobDetail
     */
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        //这⾥设定触发执⾏的⽅式
        CronScheduleBuilder scheduleBuilder =
                CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
