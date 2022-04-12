package com.crq.boot.enums;

/**
 * 在switch中使用枚举
 * @author crq
 */
public class SwitchEnum {
    public static void main(String[] args) {
        Color c = Color.BLUE;
        switch (c) {
            case BLUE -> System.out.println("蓝色");
            case RED -> System.out.println("红色");
            case GREEN -> System.out.println("绿色");
            default -> System.out.println("默认颜色");
        }
    }
}
