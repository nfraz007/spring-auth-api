package com.example.springauthapi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiResponse {
    private Integer status;
    private Object data;
    private String error;

    public ApiResponse(Integer status, Object data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse success(Object data) {
        return new ApiResponse(HttpStatus.OK.value(), data, null);
    }

    public static ApiResponse error(String error) {
        return new ApiResponse(HttpStatus.BAD_REQUEST.value(), null, error);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrors() {
        return error;
    }

    public void setErrors(String error) {
        this.error = error;
    }
}


