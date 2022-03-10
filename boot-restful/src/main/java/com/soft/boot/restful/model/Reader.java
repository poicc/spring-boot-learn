package com.soft.boot.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-10 19:12
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 9028797974864875247L;
    private Long id;
    private String name;
    private Integer age;

}
