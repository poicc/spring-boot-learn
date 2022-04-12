package com.crq.boot.enums;

/**
 * crq
 * @author crq
 */
public class InnerEnum {
    enum SEASON {
        /**
         * 颜色枚举
         */
        SPRING, SUMMER, AUTUMN, WINTER
    }

    public static void main(String[] args) {
        SEASON season = SEASON.SUMMER;
        System.out.println(season);
    }
}
