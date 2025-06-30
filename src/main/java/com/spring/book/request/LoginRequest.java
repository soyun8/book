package com.spring.book.request;

import lombok.Builder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * 로그인 요청
 */
@Getter
public class LoginRequest {

    @NotNull
    private String userEmail;

    @NotNull
    private String password;

    @Builder
    public LoginRequest(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}
