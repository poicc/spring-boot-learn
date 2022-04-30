package com.crq.boot.mapper;

import com.crq.boot.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 13:28
 **/
@Mapper
public interface UserMapper {
    /**
     * 插入user
     * @param user user
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO t_user (username,password,status,avatar) " +
            "VALUES(#{user.username},#{user.password},#{user.status}," +
            "#{user.avatar})")
    void insertUser(@Param("user") User user);

    /**
     * 更新状态-激活用户
     * @param user user
     */
    @Update("UPDATE t_user SET status = #{user.status} WHERE id = #{user.id} ")
    void updateStatus(@Param("user") User user);

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    User selectById(@Param("username") String username);
}
