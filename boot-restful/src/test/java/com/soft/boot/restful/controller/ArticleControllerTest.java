package com.soft.boot.restful.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ArticleControllerTest {
    //mock对象
    @Resource
    private MockMvc mockMvc;

    //在所有测试⽅法执⾏之前进⾏mock对象初始化
//    @BeforeAll
//    static void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new
//                ArticleController()).build();
//    }

    //测试⽅法
    @Test
    public void saveArticle() throws Exception {
        String article = """
                 {
                "id": 1,
                "author": "crq",
                "title": "SpringBoot",
                "content": "SpringBoot",
                "createTime": "2022-03-12 12:12:12",
                "readerList":
                [{"id":1,"name":"aaa","age":18},
                {"id":1,"name":"bbb","age":20}]
                }""";
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                //   MockMvc对象有以下⼏个基本的⽅法: perform : 模拟执⾏⼀个RequestBuilder构建的HTTP请求，会执⾏SpringMVC的流程并映射 到相应的控制器Controller执⾏。 contentType：发送请求内容的序列化的格式，"application/json"表示JSON数据格式 andExpect: 添加RequsetMatcher验证规则，验证控制器执⾏完成后结果是否正确，或者说是 结果是否与我们期望（Expect）的⼀致。 andDo: 添加ResultHandler结果处理器，⽐如调试时打印结果到控制台 andReturn: 最后返回相应的MvcResult,然后进⾏⾃定义验证/进⾏下⼀步的异步处理 上⾯的整个过程，我们都没有使⽤到Spring Context依赖注⼊、也没有启动tomcat web容器。整个 测试过程⼗分轻量级，速度很快。 测试注意 因为没有⽤到Spring，所以在application.yml中的时间格式化全局配置⽆效，别忘了在Article实 体类加上 ●●●●●
                                .request(HttpMethod.POST,
                                        "/api/v1/articles/body")
                                .contentType("application/json")
                                .content(article)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())//HTTP:status 200

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("crq"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readerList[0].age").value(18))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}