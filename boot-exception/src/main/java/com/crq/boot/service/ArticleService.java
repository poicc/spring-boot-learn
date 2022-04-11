package com.crq.boot.service;


import com.crq.boot.consts.MsgConsts;
import com.crq.boot.enums.CustomExceptionType;
import com.crq.boot.exception.CustomException;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-11 11:45
 **/
@Service
public class ArticleService {

    public void systemBizError() {

        try {
            Class.forName("com.mysql.jdbc.cj.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "在XXX业务，myBiz()方法内 出现ClassNotFoundException 请联系管理员处理");
        }

    }

    public void userBizError(int id) {
        //    模拟业务校验失败逻辑
        if (id < 0) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, MsgConsts.INPUT_ERROR);
        }

    }
}