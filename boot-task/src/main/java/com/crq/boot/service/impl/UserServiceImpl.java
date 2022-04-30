package com.crq.boot.service.impl;

import com.crq.boot.entity.User;
import com.crq.boot.mapper.UserMapper;
import com.crq.boot.service.MailService;
import com.crq.boot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 13:46
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MailService mailService;

    @Override
    public void activeUser(Integer id) {
        User user = User.builder().id(id).status(1).build();
        userMapper.updateStatus(user);
    }

    /**
     * 插入用户
     * @param username username
     * @param password password
     * @return 用户id
     */
    @Override
    public String insertUser(String username, String password) {
            User user = User.builder().username(username).password(password).status(0).build();
            User user1 = userMapper.selectById(username);
            if(user1 == null) {
                userMapper.insertUser(user);
                mailService.sendSimpleMail(username, "请激活您的用户", "http://localhost:8080/user/active/"+user.getId());
                return "注册成功，请前往您的邮箱进行激活";
            } else if(user1.getStatus() == 0){
                mailService.sendSimpleMail(username, "请激活您的用户", "http://localhost:8080/user/active/"+user1.getId());
                return "当前用户未激活， 请前往邮箱进行激活";
            } else {
                return "登录成功";
            }

    }
}
