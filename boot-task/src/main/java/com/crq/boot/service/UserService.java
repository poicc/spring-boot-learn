package com.crq.boot.service;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 16:07
 **/
public interface UserService {
    public void activeUser(Integer id);
    public String insertUser(String username,String password);
}
