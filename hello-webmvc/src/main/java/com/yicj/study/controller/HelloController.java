package com.yicj.study.controller;

import com.yicj.study.model.vo.RestResponse;
import com.yicj.study.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yicj
 * @date 2023年10月08日 10:14
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService ;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/index")
    public RestResponse<String> index(){
        String retValue = this.helloService.hello("张三");
        return RestResponse.success("hello world" + retValue) ;
    }
}
