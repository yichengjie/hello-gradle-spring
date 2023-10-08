package com.yicj.study.service.impl;

import com.yicj.study.service.HelloService;

/**
 * @author yicj
 * @date 2023年10月08日 15:07
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}
