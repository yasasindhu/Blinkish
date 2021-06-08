package com.luv2code.springboot.cruddemo.rest.Controller;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private  boolean flag;
    private String message;
    private HttpStatus httpStatus;

    public ApiResponse(boolean flag, String message, HttpStatus httpStatus) {
        this.flag = flag;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
