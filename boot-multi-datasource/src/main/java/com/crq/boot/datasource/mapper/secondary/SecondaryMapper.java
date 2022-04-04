package com.crq.boot.datasource.mapper.secondary;

import com.crq.boot.datasource.entity.BootUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-01 10:21
 **/

public interface SecondaryMapper {
    /**
     * 查询所有数据
     * @return list
     */
    List<BootUser> selectAll();

    /**
     * 新增
     * @param bootUser bootUser
     */
    void insert(@Param("bootUser") BootUser bootUser);
}
