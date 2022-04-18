package com.crq.boot.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-18 14:03
 **/
@ServerEndpoint(value = "/socket/{id}")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 静态变量 用来记录当前在吸纳的
     */
    private static int onlineCount = 0;

    /**
     * concurrent包中的线程安全的set 用来存放每个客户端对应的myWebsocket对象
     */
    private static ConcurrentHashMap<Integer, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接对话 获取参数
     */
    private Session session;
    private Integer id = 0;

    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer param, Session session) throws IOException {
        this.id = param;
        log.info(String.valueOf(param));
        this.session = session;
        webSocketSet.put(param, this);
        addOnlineCount();
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
        sendMessage("连接成功,欢迎您");
    }

    @OnClose
    public void onClose() {
        if (id != null && id != 0) {
            webSocketSet.remove(this);
            subOnlineCount();
            log.info("有连接关闭！当前在线人数为" + getOnlineCount());
        }

    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
//        String queryString = session.getQueryString();
//        String nickname = queryString.split("=")[1];
//        log.info(nickname);
        log.info(message);
        sendMessage(message);
    }

    @OnError
    public void onError(Throwable error) {
        log.error("发送错误,{}", error.getMessage());
    }

    public void broadcastInfo(String message) throws IOException {
        try {
            for (WebSocketServer item : webSocketSet.values()) {
                item.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendToMessageById(Integer id, String message) {
        try {
            if (webSocketSet.get(id) != null) {
                webSocketSet.get(id).sendMessage(message);
            } else {
                log.info("webSocketSet中没有此key 不推送消息");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 封装基础的发送信息操作
     *
     * @param message 入参消息
     * @throws IOException io
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
}


