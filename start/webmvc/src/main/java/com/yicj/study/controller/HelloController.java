package com.yicj.study.controller;

import com.yicj.study.model.vo.RestResponse;
import com.yicj.study.service.HelloService;
import com.yicj.study.utils.CommonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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
        CommonUtils.printList(Arrays.asList("1"), 1);
        String retValue = this.helloService.hello("张三");
        return RestResponse.success("hello world " + retValue) ;
    }
}
