package com.crq.file.util;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 10:52
 **/
public class CustomException extends RuntimeException{
    /**
     * 异常错误编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    private CustomException() {

    }

    public CustomException(CustomExceptionType customExceptionType) {
        this.code = customExceptionType.getCode();
        this.message = customExceptionType.getDesc();
    }

    public CustomException(CustomExceptionType customExceptionType, String message) {
        this.code = customExceptionType.getCode();
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
