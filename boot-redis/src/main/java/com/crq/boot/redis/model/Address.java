package com.crq.boot.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-17 19:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -6161694392107907902L;

    private String country;
    private String city;
}
