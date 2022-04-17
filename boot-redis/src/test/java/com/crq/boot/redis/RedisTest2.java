package com.crq.boot.redis;

import com.crq.boot.redis.model.Address;
import com.crq.boot.redis.model.Person;
import com.crq.boot.redis.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-17 19:38
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class RedisTest2 {
    @Resource
    private PersonRepository personRepository;

    @Test
    public void testRedisRepository() {
        Person person =  Person.builder().id(1).firstName("陈").lastName("蓉琪").address(new Address("中国","南京")).build();
        personRepository.save(person);
        Optional<Person> op = personRepository.findById(person.getId());
        op.ifPresent(value -> log.info(String.valueOf(value)));
        log.info(String.valueOf(personRepository.count()));
//        personRepository.delete(person);
    }
}
