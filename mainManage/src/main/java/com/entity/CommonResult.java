package com.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(String code, String message) {
        this(code, message, null);
    }

    public CommonResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
