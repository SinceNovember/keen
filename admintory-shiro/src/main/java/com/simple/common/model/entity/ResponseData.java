package com.simple.common.model.entity;


import lombok.Data;

/**
 * 返回实体
 */
@Data
public class ResponseData {

    private int code;

    private String msg;

    private Object data;

    public ResponseData(int code) {
        this.code = code;
    }

    public ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }


}
