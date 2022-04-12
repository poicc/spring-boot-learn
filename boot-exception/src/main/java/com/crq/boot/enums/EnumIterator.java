package com.crq.boot.enums;

/**
 * 枚举迭代
 * @author crq
 */
public class EnumIterator {
    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }
}
