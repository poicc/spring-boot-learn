package com.crq.boot.orm.dozer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-28 10:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestA {
    private String name;
    private String cTime;
}
