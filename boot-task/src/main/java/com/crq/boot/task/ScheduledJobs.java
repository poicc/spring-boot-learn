package com.crq.boot.task;

import com.crq.boot.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.Date;

/**
 * @description: Scheduled定时任务
 * @author: crq
 * @create: 2022-04-12 16:50
 **/
//@Component
public class ScheduledJobs {
    @Resource
    private MailService mailService;

    /**
     * 方法执行完成后5秒再开始执行定时任务
     *
     * @throws InterruptedException 中断异常
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        System.out.println("fixedDelay 开始:" + new Date());
        Thread.sleep(5 * 1000);
        System.out.println("fixedDelay 结束:" + new Date());
    }

    /**
     * 每隔三秒执行 定时任务
     *
     * @throws InterruptedException 中断异常
     */
    @Scheduled(fixedRate = 3000)
    public void fixedRateJob() throws InterruptedException {
        System.out.println("=======fixedRate 开始:" + new Date());
        Thread.sleep(5 * 1000);
        System.out.println("=======fixedRate 结束:" + new Date());
    }

    //    @Scheduled(cron = "0 0 20 12 4 ? 2022-2022")
    @Scheduled(cron = "0 0 20 * * ? ")
    public void cronJob() throws MessagingException {
        mailService.sendSimpleMail("16422802@qq.com", "来自陈蓉琪的定时邮件", "老班 这周的后端内容我很想学٩(◦`꒳´◦)۶ 不管是哪一项都是不可或缺的");
        System.out.println("=============== ...>>cron...." + new Date());
    }
}
