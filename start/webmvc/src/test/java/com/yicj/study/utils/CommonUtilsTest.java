package com.yicj.study.utils;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * @author yicj
 * @date 2023年10月09日 11:32
 */
public class CommonUtilsTest {

    @Test
    public void printList(){
        List<String> list = Arrays.asList("1", "2", "3") ;
        CommonUtils.printList(list, 2);
    }
}
