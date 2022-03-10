package com.soft.boot.restful.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soft.boot.restful.model.Reader;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-10 19:46
 **/
public class JsonMapper {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Reader article = new Reader(1L,"crq",2);
        //序列化
        String jsonStr = mapper.writeValueAsString(article);
        //反序列化
        String json = """
                {
                "id":1, "name":"crq", "age":2
                }
                """;
        Reader reader = mapper.readValue(json, Reader.class);
        System.out.println(jsonStr);
        System.out.println(reader);
    }
}
