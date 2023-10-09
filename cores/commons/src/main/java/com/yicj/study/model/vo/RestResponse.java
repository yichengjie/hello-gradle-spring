package com.yicj.study.model.vo;

import lombok.Data;
import java.io.Serializable;

/**
 * @author yicj
 */
@Data
public class RestResponse <T> implements Serializable {

    public static final String SUCCESS_CODE = "00000" ;

    private String code ;

    private String msg ;

    private T data ;

    public static <T> RestResponse<T> success(T data){
        RestResponse <T> restResponse = new RestResponse<>() ;
        restResponse.setCode(SUCCESS_CODE);
        restResponse.setData(data);
        return restResponse ;
    }

    public static <T> RestResponse<T> fail(String code, String msg){
        RestResponse <T> restResponse = new RestResponse<>() ;
        restResponse.setCode(code);
        restResponse.setMsg(msg);
        return restResponse ;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
}
