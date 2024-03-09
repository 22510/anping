package com.ins.anping.model.common;

import lombok.Data;

import java.io.Serializable;


/**
 * 通用的结果返回类
 * @param <T>
 */
@Data
public class ResponseResult<T> implements Serializable {

    /**
     * 成功200
     * 失败500
     */
    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
        this.code = 200;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult okResult(int code, String msg, Object data) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, data, msg);
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.message = msg;
        return this;
    }

//    public ResponseResult<?> ok(Integer code, T data) {
//        this.code = code;
//        this.data = data;
//        return this;
//    }

    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.message = msg;
        return this;
    }

//    public ResponseResult<?> ok(T data) {
//        this.data = data;
//        return this;
//    }

//    public String getErrorMessage() {
//        return message;
//    }
//
//    public void setErrorMessage(String errorMessage) {
//        this.message = errorMessage;
//    }

}
