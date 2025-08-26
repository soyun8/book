package com.spring.book.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST.value(), "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "C002", " Method not allowed"),
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "C003", "Entity Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "C004", "Server Error"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST.value(), "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN.value(), "C006", "접근 권한이 없습니다."), // Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생
    INVALID_ENUM_CODE(HttpStatus.BAD_REQUEST.value(), "C007", "Invalid Enum Code"),
    EXTERNAL_API_NOT_RESPONSE(HttpStatus.REQUEST_TIMEOUT.value(), "C008", "External Api doesn't response(Timeout"),
    PARSING_ERROR(HttpStatus.BAD_REQUEST.value(), "C009", "문자열 파싱 에러"),
    CRYPT_ERROR(HttpStatus.BAD_REQUEST.value(), "C010", "암호화 오류"),
    NO_CONTENT(HttpStatus.NO_CONTENT.value(), "C011", "데이터가 존재하지 않습니다"),

    // User
    NOT_LOGGED_IN(HttpStatus.UNAUTHORIZED.value(), "U001", "가입 정보가 없습니다."),
    NOT_ALLOWED_SIGN(HttpStatus.UNAUTHORIZED.value(), "U002", "회원가입 권한이 없는 사용자입니다."),
    DUPLICATE_ID(HttpStatus.BAD_REQUEST.value(), "U003", "다른 아이디를 사용해주세요"),


    // Session
    ACCESSED_EXPIRED_SESSION_TOKEN(HttpStatus.UNAUTHORIZED.value(), "S001", "만료된 토큰입니다. 다시 확인해주세요"),

    // Open API
    API_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "OP001", "외부 API 요청이 실패했습니다."),
    API_REQUEST_ERROR(HttpStatus.BAD_REQUEST.value(), "OP002", "요청값이 잘못되었습니다.");

    private final int status;
    private final String code;
    private final String message;
}
