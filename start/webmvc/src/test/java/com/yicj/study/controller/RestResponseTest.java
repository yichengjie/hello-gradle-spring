package com.yicj.study.controller;

import com.yicj.study.model.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author yicj
 * @date 2023年10月08日 11:31
 */
@Slf4j
public class RestResponseTest {
    @Test
    public void hello(){
        RestResponse<String> response = RestResponse.fail("4001", "用户名不能为空");
        log.info("response value : {}", response);
    }
}
