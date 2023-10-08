package com.yicj.study.controller;

import com.yicj.study.service.HelloService;
import com.yicj.study.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HelloControllerStandaloneTest {
    MockMvc mockMvc;
    // 这里不能使用MockBean
    HelloService helloService ;

    @BeforeEach
    void setup() {
        helloService = new HelloServiceImpl();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController(helloService))
                //.defaultRequest(MockMvcRequestBuilders.get("/hello/index").accept(MediaType.APPLICATION_JSON))
                .alwaysExpect(status().isOk())
                .alwaysExpect(content().contentType("application/json"))
                .build();
    }
    @Test
    void index() throws Exception {
        //given(this.helloService.hello("张三")).willReturn("hello, 张三") ;
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello/index")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print()) ;
    }
}