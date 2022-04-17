package com.crq.boot.redis.repository;

import com.crq.boot.redis.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-17 19:40
 **/
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
