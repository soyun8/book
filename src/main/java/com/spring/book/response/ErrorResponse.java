package com.spring.book.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private String code;
    private  String message;
    private int status;

    @Builder
    public ErrorResponse (String code, String message, int status) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
