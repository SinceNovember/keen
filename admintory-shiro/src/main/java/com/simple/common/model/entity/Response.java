package com.simple.common.model.entity;

import com.simple.common.model.entity.ResponseData;
import org.springframework.http.HttpStatus;

/**
 * 统一返回模板
 */
public class Response {

    public static ResponseData ok(){
        return new ResponseData(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static ResponseData ok(Object data){
        return new ResponseData(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
    }


    public static ResponseData ok(String msg) {
        return new ResponseData(HttpStatus.OK.value(), msg);
    }

    public static ResponseData ok(String data, String msg) {
        return new ResponseData(HttpStatus.OK.value(), data, msg);
    }

    public static ResponseData ok(HttpStatus httpStatus){
        return new ResponseData(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static ResponseData ok(HttpStatus httpStatus, String msg){
        return new ResponseData(httpStatus.value(), msg);
    }

    public static ResponseData ok(HttpStatus httpStatus, Object data){
        return new ResponseData(httpStatus.value(), data, httpStatus.getReasonPhrase());
    }

    public static ResponseData fail(Object data){
        return new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), data, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static ResponseData fail(String msg) {
        return new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ResponseData fail(String data, String msg) {
        return new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), data, msg);
    }

    public static ResponseData fail(){
        return new ResponseData(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static ResponseData fail(HttpStatus httpStatus){
        return new ResponseData(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static ResponseData fail(HttpStatus httpStatus, String msg){
        return new ResponseData(httpStatus.value(), msg);
    }
    public static ResponseData fail(HttpStatus httpStatus, Object data){
        return new ResponseData(httpStatus.value(), data, httpStatus.getReasonPhrase());
    }


}
