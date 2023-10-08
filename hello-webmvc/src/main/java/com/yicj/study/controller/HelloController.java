package com.yicj.study.controller;

import com.yicj.study.model.vo.RestResponse;
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

    @GetMapping("/index")
    public RestResponse<String> index(){

        return RestResponse.success("hello world") ;
    }
}
