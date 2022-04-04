package com.crq.boot.datasource.service;

import com.crq.boot.datasource.entity.BootUser;
import com.crq.boot.datasource.mapper.primary.PrimaryMapper;
import com.crq.boot.datasource.mapper.secondary.SecondaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-01 10:31
 **/
@Service
public class BootUserService {
    @Resource
    private PrimaryMapper primaryMapper;
    @Resource
    private SecondaryMapper secondaryMapper;

    public List<BootUser> getUsers() {
        List<BootUser> primaryUsers = primaryMapper.selectAll();
        List<BootUser> secondaryUsers = secondaryMapper.selectAll();
        List<BootUser> result = new ArrayList<>();
        result.addAll(primaryUsers);
        result.addAll(secondaryUsers);
        return result;
    }

//    @Transactional(rollbackFor = {RuntimeException.class})
    public void saveUser(BootUser bootUser) {
        primaryMapper.insert(bootUser);
//        int a = 2 / 0;
        secondaryMapper.insert(bootUser);
    }
}
