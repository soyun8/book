package com.spring.book.response;

import lombok.Builder;
import lombok.Getter;

/**
 * 로그인 성공시 응답할 필드
 */
@Getter
public class LoginResponse {

    private String status;
    private String accessToken;
    private String userEmail;

    @Builder
    public LoginResponse(String status, String accessToken, String userEmail) {
        this.status = status;
        this.accessToken = accessToken;
        this.userEmail = userEmail;
    }
}
