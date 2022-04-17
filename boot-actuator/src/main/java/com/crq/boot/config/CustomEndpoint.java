package com.crq.boot.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-15 09:04
 **/
@Configuration
@Endpoint(id = "customEndpoint")
//@EndpointExtension()
public class CustomEndpoint {


    /**
     *  @WriteOperation 可写
     *  @DeleteOperation 可删除
     * @return ShopData
     */
    @ReadOperation
    public ShopData getData() {
        return new ShopData("zhangsan","江苏南京");
    }

    @Data
    @AllArgsConstructor
    public static class ShopData {
        private String name;
        private String address;
    }
}
