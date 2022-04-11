package com.crq.boot.enums;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 10:44
 **/
public enum CustomExceptionType {

    /**
     * 客户端异常
     */
    USER_INPUT_ERROR(400,"您输入的数据错误或您没有权限访问资源"),

    /**
     * 服务器异常
     */
    SYSTEM_ERROR(500,"系统出现异常，请您稍后再试或练习管理员"),

    /**
     * 未知异常
     */
    OTHER_ERROR(999,"系统出现位置异常，请联系管理员");

    /**
     * 异常类型状态码
     */
    private final int code;

    /**
     * 异常类型中文描述
     */
    private final String desc;

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CustomExceptionType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
