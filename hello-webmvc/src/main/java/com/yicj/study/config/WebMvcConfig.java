package com.yicj.study.config;

import com.yicj.study.service.HelloService;
import com.yicj.study.service.impl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author yicj
 * @date 2023年10月08日 15:06
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yicj.study.controller")
public class WebMvcConfig {
    @Bean
    public HelloService helloService(){
        return new HelloServiceImpl() ;
    }
}
