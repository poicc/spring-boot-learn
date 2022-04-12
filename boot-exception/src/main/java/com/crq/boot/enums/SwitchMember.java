package com.crq.boot.enums;

/**
 * 枚举成员
 * @author crq
 */
public class SwitchMember {
    public static void main(String[] args) {
        Platform p = Platform.IOS;
        System.out.println(p);
        p.platformInfo();

    }
}

enum Platform {
    /**
     * 平台枚举
     */
    ANDROID, IOS, WEB;

    /**
     * 构造方法，默认私有
     */
    Platform() {
        System.out.println("构造方法被调用：" + this);
    }

    public void platformInfo() {
        System.out.println("平台信息：" + this);
    }
}