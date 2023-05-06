package com.simple.keen.common.base;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 统一返回模板
 */
@Data
@ToString
public class Response {

    private int code;

    private String msg;

    private Object data;

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Response ok() {
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    public static Response ok(Object data) {
        return new Response(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
    }

    public static Response ok(int code, String msg) {
        return new Response(code, msg);
    }

    public static Response ok(String data, String msg) {
        return new Response(HttpStatus.OK.value(), data, msg);
    }

    public static Response ok(HttpStatus httpStatus) {
        return new Response(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static Response ok(HttpStatus httpStatus, String msg) {
        return new Response(httpStatus.value(), msg);
    }

    public static Response ok(HttpStatus httpStatus, Object data) {
        return new Response(httpStatus.value(), data, httpStatus.getReasonPhrase());
    }

    public static Response fail(Object data) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), data, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static Response fail(String msg) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static Response fail(int code, String msg) {
        return new Response(code, msg);
    }

    public static Response fail(String data, String msg) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), data, msg);
    }

    public static Response fail() {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static Response fail(HttpStatus httpStatus) {
        return new Response(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    public static Response fail(HttpStatus httpStatus, String msg) {
        return new Response(httpStatus.value(), msg);
    }

    public static Response fail(HttpStatus httpStatus, Object data) {
        return new Response(httpStatus.value(), data, httpStatus.getReasonPhrase());
    }
}
