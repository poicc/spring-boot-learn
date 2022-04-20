package com.crq.boot.websocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-19 15:59
 **/
@Slf4j
@Controller
public class DemoController {
    @RequestMapping(value = "/server/info", method = {RequestMethod.GET}, produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg() {
        final SseEmitter emitter = new SseEmitter(0L);
        log.info("emitter push message ......");
        List<String> list = new ArrayList<>();
        System.out.println(list);
        list.add("今天也要元气满满鸭");
        list.add("nice day !!");
        list.add("\uD83C\uDF53 \uD83C\uDF51");
        try {
            emitter.send(list.toString(), MediaType.TEXT_EVENT_STREAM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emitter;
    }
}
