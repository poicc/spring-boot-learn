package com.crq.file.util;

/**
 * @author crq
 */

public enum CustomExceptionType {
    /**
     * 客户端异常
     */

    USER_INPUT_ERROR(400, "输入的数据错误或您没有权限访问资源！"),

    /**
     * 服务器异常
     */

    SYSTEM_ERROR(500, "系统出现异常，请稍后重试"),

    /**
     * 未知异常
     */
    OTHER_ERROR(999, "系统出现未知异常！");

    CustomExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 异常类型中文描述
     */
    public final String desc;

    /**
     * 异常类型状态码
     */
    private final int code;

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

}
