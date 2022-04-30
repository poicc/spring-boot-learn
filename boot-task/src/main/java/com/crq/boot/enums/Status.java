package com.crq.boot.enums;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 15:41
 **/
public enum Status {
    /**
     * 未激活
     */
    NO_ACTIvE(0),
    /**
     * 激活
     */
    ACTIVE(1);

    private final Integer value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
