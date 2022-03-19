package com.crq.boot.orm.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.IllformedLocaleException;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 09:02
 **/
@Component
@Slf4j
public class DataBaseAuditListener {
    /**
     * 新增数据时填充时间
     * @param object
     * @throws IllegalAccessException
     * @throws IllformedLocaleException
     */
    @PrePersist
    public void  prePersist(Object object) throws IllegalAccessException, IllformedLocaleException{
        Class<?> aClass = object.getClass();
        try {
            addOperateTime(object, aClass,"createTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常:",e);
        }
    }

    @PreUpdate
    public void preUpdate(Object object)  throws IllegalAccessException, IllformedLocaleException{
        Class<?> aClass = object.getClass();
        try {
            addOperateTime(object,aClass,"updateTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常:",e);
        }
    }

    /**
     * 填充操作时间
     * @param object 入参
     * @param aClass 反射对象
     * @param propertyName 属性名(反对实体类中的属性)
     * @throws NoSuchFieldException 异常
     * @throws IllegalAccessException 异常
     */

    protected void addOperateTime(Object object,Class<?> aClass,String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field time = aClass.getDeclaredField(propertyName);
        time.setAccessible(true);
//         获取time值
        Object createTimeValue = time.get(object);
        if (createTimeValue == null) {
            time.set(object,new Date());
        }
    }
    /**
     * 新增数据之后的操作
     * @param object
     * @throws IllegalAccessException
     * @throws IllformedLocaleException
     */
    @PostPersist
    public void postPersist(Object object) throws IllegalAccessException, IllformedLocaleException {

    }

    /**
     * 更新数据之后的操作
     * @param object
     * @throws IllegalAccessException
     * @throws IllformedLocaleException
     */
    @PostUpdate
    public void postUpdate(Object object)throws IllegalAccessException, IllformedLocaleException{

    }
}

