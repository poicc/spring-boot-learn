package com.crq.boot.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-04 15:25
 **/
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
