//package com.crq.boot.websocket.config;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * @description:
// * @author: crq
// * @create: 2022-04-18 10:41
// **/
//@ServerEndpoint(value = "/websocket")
//@Component
//@Slf4j
//@Data
//public class MyWebSocket {
//    /**
//     * 静态变量 用来记录当前在吸纳的
//     */
//    private static int onlineCount = 0;
//
//    /**
//     * concurrent包中的线程安全的set 用来存放每个客户端对应的myWebsocket对象
//     */
//    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
//
//    /**
//     * 与某个客户端的连接对话 获取参数
//     */
//    private Session session;
//
//    @OnOpen
//    public void onOpen(Session session) throws IOException {
//        this.session = session;
//        String queryString = session.getQueryString();
//        String nickname = queryString.split("=")[1];
//        webSocketSet.add(this);
//        addOnlineCount();
//        log.info("有新连接加入！当前在线人数为" + getOnlineCount());
//        sendMessage(nickname + "连接成功,欢迎您");
//    }
//
//    @OnClose
//    public void onClose() {
//        webSocketSet.remove(this);
//        subOnlineCount();
//        log.info("有连接关闭！当前在线人数为" + getOnlineCount());
//    }
//
//    @OnMessage
//    public void onMessage(String message, Session session) throws IOException {
//        String queryString = session.getQueryString();
//        String nickname = queryString.split("=")[1];
//        log.info(nickname);
//        log.info(message);
//        broadcastInfo(nickname + "说:" + message);
//    }
//
//    @OnError
//    public void onError(Throwable error) {
//        log.error("发送错误,{}", error.getMessage());
//    }
//
//    public static void broadcastInfo(String message) throws IOException {
//        for (MyWebSocket item : webSocketSet) {
//            item.sendMessage(message);
//        }
//    }
//
//
//    /**
//     * 封装基础的发送信息操作
//     *
//     * @param message 入参消息
//     * @throws IOException io
//     */
//    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
//    }
//
//    public static synchronized void addOnlineCount() {
//        MyWebSocket.onlineCount++;
//    }
//
//    public static synchronized void subOnlineCount() {
//        MyWebSocket.onlineCount--;
//    }
//
//    public static synchronized int getOnlineCount() {
//        return onlineCount;
//    }
//}
