package com.crq.boot.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-19 10:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_people")
public class People {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private int age;
}
