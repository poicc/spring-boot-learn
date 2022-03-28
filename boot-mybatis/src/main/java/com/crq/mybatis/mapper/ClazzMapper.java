package com.crq.mybatis.mapper;


import com.crq.mybatis.domain.Clazz;
import org.apache.ibatis.annotations.Mapper;

/**
* @author crq
 * @Entity generator.domain.Clazz
*/
@Mapper
public interface ClazzMapper {
    /**
     * 根据班级id查询班级信息
     * @param clazzId 班级Id
     * @return clazz
     */
    Clazz findOneByMany(int clazzId);

    /**
     * 根据班级Id查询班级信息
     * @param clazzId clazzId
     * @return clazz
     */
    Clazz getClazz(int clazzId);

}
