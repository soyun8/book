package com.spring.book.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * 로그인 요청
 */
@Getter
public class LoginRequest {

    @NotNull
    @JsonProperty("email")
    private String userEmail;

    @NotNull
    @JsonProperty("pwd")
    private String password;

    @Builder
    public LoginRequest(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }
}
