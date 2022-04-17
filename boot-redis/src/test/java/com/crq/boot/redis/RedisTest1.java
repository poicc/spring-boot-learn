package com.crq.boot.redis;

import com.crq.boot.redis.model.Address;
import com.crq.boot.redis.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-17 18:57
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class RedisTest1 {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Person> redisTemplate;

    @Test
    public void testString() {
        ValueOperations<String, String> stringOperations = stringRedisTemplate.opsForValue();
        stringOperations.set("name", "张三", 20, TimeUnit.SECONDS);
        String name = stringOperations.get("name");
        log.info(name);
    }

    @Test
    public void testObject() {
        Address address = new Address("中国", "北京");
        Person person = Person.builder().
                id(1).firstName("李").lastName("明").address(address).build();
        ValueOperations<String, Person> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("person:object",person,20,TimeUnit.SECONDS);
        Person person1 = valueOperations.get("person:object");
        log.info(String.valueOf(person1));
    }

    @Test
    public void testList() {
        ListOperations<String, Person> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("person:list",Person.builder().id(1).firstName("张").lastName("三").build());
        listOperations.leftPush("person:list",Person.builder().id(2).firstName("张").lastName("三丰").build());
        listOperations.leftPush("person:list",Person.builder().id(3).firstName("张").lastName("三风").build());
        //取出来是后放入的数据
        Person person = listOperations.leftPop("person:list");
        log.info(String.valueOf(person));
    }

    @Test
    public void testListRight() {
        ListOperations<String, Person> listOperations = redisTemplate.opsForList();
        listOperations.rightPush("person:list",Person.builder().id(1).firstName("张").lastName("三").build());
        listOperations.rightPush("person:list",Person.builder().id(2).firstName("张").lastName("三丰").build());
        listOperations.rightPush("person:list",Person.builder().id(3).firstName("张").lastName("三风").build());
        //取出来是后放入的数据
        Person person = listOperations.rightPop("person:list");
        log.info(String.valueOf(person));
    }

    @Test
    public void testSet() {
        SetOperations<String, Person> setOperations = redisTemplate.opsForSet();
        Person person1 = Person.builder()
                .id(1)
                .firstName("张")
                .lastName("三")
                .build();
        Person person2 = Person.builder()
                .id(2)
                .firstName("李")
                .lastName("四")
                .build();
        setOperations.add("person:set",person1,person1,person2);
        Set<Person> members = setOperations.members("person:set");
        log.info(String.valueOf(members));
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Person person = Person.builder()
                .id(1)
                .firstName("张")
                .lastName("三")
                .address(new Address("中国","北京"))
                .build();
        hashOperations.put("hash:person","id",person.getId());
        hashOperations.put("hash:person","firstName",person.getFirstName());
        hashOperations.put("hash:person","lastName",person.getLastName());
        hashOperations.put("hash:person","address",person.getAddress());

        Integer id = (Integer) hashOperations.get("hash:person", "id");
        String firstName = (String) hashOperations.get("hash:person", "firstName");
        String lastName = (String) hashOperations.get("hash:person", "lastName");
        Address address = (Address) hashOperations.get("hash:person", "address");
        log.info("{},{},{},{}",id,firstName,lastName,address);
    }
}
