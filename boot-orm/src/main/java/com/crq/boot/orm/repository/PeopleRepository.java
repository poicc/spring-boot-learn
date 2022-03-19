package com.crq.boot.orm.repository;

import com.crq.boot.orm.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 10:37
 **/
public interface PeopleRepository extends JpaRepository<People,Integer> {
    /**
     * 查找全部
     * @return all
     */
    @Override
    List<People> findAll();

    /**
     * 根据firstname查找
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstName(String firstName);

    /**
     * 根据firstName和LastName查找(两者必须在数据库有)
     * @param firstName firstName
     * @param lastname lastname
     * @return people
     */
    People findByFirstNameAndLastName(String firstName, String lastname);

    /**
     * 根据firstName或LastName查找(两者其一有就行)
     * @param lastName lastName
     * @param firstName firstName
     * @return people
     */
    People findByLastNameOrFirstName(String lastName,String firstName);

    /**
     * 根据firstName查找它是否存在数据库里
     * @param firstName firstName
     * @return people
     */
    People findByFirstNameIs(String firstName);

    /**
     * 根据firstName查找它是否存在数据库里
     * @param firstName firstName
     * @return people
     */
    People findByFirstNameEquals(String firstName);

    /**
     * 在Age数值age到age2之间的数据
     * @param age1 age1
     * @param age2 age2
     * @return list
     */
    List<People> findByAgeBetween(Integer age1, Integer age2);

    /**
     * 小于指定age数值之间的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeLessThan(Integer age);

    /**
     * 小于等于指定age数值的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeLessThanEqual(Integer age);

    /**
     * 大于指定age数值之间的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeGreaterThan(Integer age);

    /**
     * 大于或等于指定age数值之间的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeGreaterThanEqual(Integer age);

    /**
     * 在指定age数值之前的数据类似关键字<LessThan>
     * @param age age
     * @return list
     */
    List<People> findByAgeAfter(Integer age);

    /**
     * 在指定age数值之后的数据类似关键字<GreaterThan>
     * @param age age
     * @return list
     */
    List<People> findByAgeBefore(Integer age);

    /**
     * 返回age字段为空的数据
     * @return list
     */
    List<People> findByAgeIsNull();

    /**
     * 返回age字段不为空的数据
     * @return list
     */
    List<People> findByAgeNotNull();


    /**
     * 类似findByFirstName
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameLike(String firstName);

    /**
     * 类似findByFirstNameNot
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameNotLike(String firstName);

    /**
     * 返回不是指定firstName的所有数据
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameNot(String firstName);

    /**
     * 查找数据库中指定类似的名字(如：输入一个名字"M" Jpa会返回多个包含M开头的名字的数据源)<类似数据库模糊查询>
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameStartingWith(String firstName);

    /**
     * 查找数据库中指定不类似的名字(同上)
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameEndingWith(String firstName);

    /**
     * 查找包含的指定数据源(这个与以上两个字段不同的地方在与它必须输入完整的数据才可以查询)
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameContaining(String firstName);

    /**
     * 根据age选取所有的数据源并按照LastName进行升序排序
     * @param age age
     * @return list
     */
    List<People> findByAgeOrderByFirstName(Integer age);

    /**
     * 返回不是指定age的所有数据
     * @param age age
     * @return list
     */
    List<People> findByAgeNot(Integer age);

    /**
     * 查找包含多个指定age返回的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeIn(List<Integer> age);

    /**
     * 查找包含多个指定age返回的数据
     * @param age age
     * @return list
     */
    List<People> findByAgeNotIn(List<Integer> age);

    /**
     * 查找
     * @param firstName firstName
     * @return list
     */
    List<People> findByFirstNameIgnoreCase(String firstName);

//    /**
//     * cha
//     * @return list
//     */
//    List<People> findByActiveTrue();
//
//    /**
//     * 查找
//     * @return list
//     */
//    List<People> findByActiveFalse();


}
