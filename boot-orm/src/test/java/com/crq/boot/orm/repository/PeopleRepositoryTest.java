package com.crq.boot.orm.repository;

import com.crq.boot.orm.entity.People;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class PeopleRepositoryTest {

    @Resource
    private PeopleRepository peopleRepository;

//    @Test
//    public void findAll() {
//        List<People> peopleList = peopleRepository.findAll();
//        assertEquals(2, peopleList.size());
//    }

    @Test
    public void findByFirstName() {
        List<People> peopleList = peopleRepository.findByFirstName("chen");
        assertEquals(1, peopleList.size());
    }

//    @Test
//    public void findByFirstNameAndLastName() {
//        People people = peopleRepository.findByFirstNameAndLastName("chen", "rongqi");
//        assertEquals(people.getLastName(), "rongqi");
//    }

//    @Test
//    public void findByLastNameOrFirstName() {
//        People people = peopleRepository.findByLastNameOrFirstName("rongqi", "chen");
//        assertEquals(people.getLastName(), "rongqi");
//    }

//    @Test
//    public void findByFirstNameIs() {
//        People people = peopleRepository.findByFirstNameIs("chen");
//        assertNull(people);
//    }

//    @Test
//    public void findByFirstNameEquals() {
//        People people = peopleRepository.findByFirstNameEquals("chen");
//        assertNull(people);
//    }

    @Test
    public void findByAgeBetween() {
        List<People> peopleList = peopleRepository.findByAgeBetween(20, 22);
        assertEquals(3, peopleList.size());
    }

    @Test
    public void findByAgeLessThan() {
        List<People> peopleList = peopleRepository.findByAgeLessThan(21);
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByAgeLessThanEqual() {
        List<People> peopleList = peopleRepository.findByAgeLessThanEqual(21);
        assertEquals(2, peopleList.size());
    }

    @Test
    public void findByAgeGreaterThan() {
        List<People> peopleList = peopleRepository.findByAgeGreaterThan(21);
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByAgeGreaterThanEqual() {
        List<People> peopleList = peopleRepository.findByAgeGreaterThanEqual(21);
        assertEquals(2, peopleList.size());
    }

    @Test
    public void findByAgeAfter() {
        List<People> peopleList = peopleRepository.findByAgeAfter(20);
        assertEquals(2, peopleList.size());
    }

    @Test
    public void findByAgeBefore() {
        List<People> peopleList = peopleRepository.findByAgeBefore(21);
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByAgeIsNull() {
        List<People> peopleList = peopleRepository.findByAgeIsNull();
        assertEquals(0, peopleList.size());
    }

    @Test
    public void findByAgeNotNull() {
        List<People> peopleList = peopleRepository.findByAgeNotNull();
        assertEquals(3, peopleList.size());
    }

    @Test
    public void findByFirstNameLike() {
        List<People> peopleList = peopleRepository.findByFirstNameLike("c");
        assertEquals(0, peopleList.size());
    }

    @Test
    public void findByFirstNameNotLike() {
        List<People> peopleList = peopleRepository.findByFirstNameNotLike("q");
        assertEquals(3, peopleList.size());
    }

    @Test
    public void findByFirstNameNot() {
        List<People> peopleList = peopleRepository.findByFirstNameNot("q");
        assertEquals(3, peopleList.size());
    }

    @Test
    public void findByFirstNameStartingWith() {
        List<People> peopleList = peopleRepository.findByFirstNameStartingWith("c");
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByFirstNameEndingWith() {
        List<People> peopleList = peopleRepository.findByFirstNameEndingWith("chen");
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByFirstNameContaining() {
        List<People> peopleList = peopleRepository.findByFirstNameContaining("c");
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByAgeOrderByFirstName() {
        List<People> peopleList = peopleRepository.findByAgeOrderByFirstName(20);
        for (People people: peopleList) {
            log.info("数据结果" + people.toString());
        }
    }

    @Test
    public void findByAgeNot() {
        List<People> peopleList = peopleRepository.findByAgeNot(20);
        assertEquals(2, peopleList.size());
    }

    @Test
    public void findByAgeIn() {
        List<People> peopleList = peopleRepository.findByAgeIn(Arrays.asList(20, 21));
        assertEquals(2, peopleList.size());
    }

    @Test
    public void findByAgeNotIn() {
        List<People> peopleList = peopleRepository.findByAgeNotIn(Arrays.asList(20, 21));
        assertEquals(1, peopleList.size());
    }

    @Test
    public void findByFirstNameIgnoreCase() {
        List<People> peopleList = peopleRepository.findByFirstNameIgnoreCase("chen");
        assertEquals(1, peopleList.size());
    }

//    @Test
//    public void findByActiveFalse() {
//        List<People> peopleList = peopleRepository.findByActiveFalse();
//        assertEquals(2, peopleList.size());
//    }
//
//    @Test
//    public void findByActiveTrue() {
//        List<People> peopleList = peopleRepository.findByActiveTrue();
//        assertEquals(2, peopleList.size());
//    }
}