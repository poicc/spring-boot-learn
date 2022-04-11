package com.crq.boot.utils;


import com.crq.boot.enums.CustomExceptionType;
import com.crq.boot.exception.CustomException;
import lombok.Data;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: ycshang
 * @create: 2022-04-11 10:49
 **/
@Data
public class AjaxResponse {
    /**
     * 请求响应状态
     */
    private int code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据
     */
    private Object data;


    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    public static AjaxResponse error(CustomExceptionType exceptionTypeEnum, String errorMessage) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(exceptionTypeEnum.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setMessage("请求响应成功");
        return resultBean;
    }
    public static AjaxResponse success(Object obj) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setMessage("请求响应成功");
        resultBean.setData(obj);
        return resultBean;
    }
    public static AjaxResponse success(Object obj,String message) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(200);
        resultBean.setMessage(message);
        resultBean.setData(obj);
        return resultBean;
    }



}