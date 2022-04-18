package com.crq.boot.websocket.service;

import com.crq.boot.websocket.config.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-18 14:19
 **/
@Service
public class TaskService {
    @Resource
    private WebSocketServer webSocketServer;

    @Scheduled(cron = "10 50 15 * * ?")
    public void sendToAll() throws IOException {
        webSocketServer.broadcastInfo("该上课啦");
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void sendMsgById() {
        webSocketServer.sendToMessageById(1,"看电脑时间太长啦 休息一会吧");
    }

    @Scheduled(cron = "0 */10 * * * ?")
    public void sendMsgById1() {
        webSocketServer.sendToMessageById(1,"看电脑时间太长啦 休息一会吧");
    }
}
