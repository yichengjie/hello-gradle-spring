package com.yicj.study.utils;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * @author yicj
 * @date 2023年10月09日 11:22
 */
@Slf4j
public class CommonUtils {

    public static <T> void  printList(List<T> list, int count){
        list.stream().limit(count)
                .forEach(item -> log.info("==> : {}", item));
    }
}
