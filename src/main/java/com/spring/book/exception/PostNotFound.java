package com.spring.book.exception;

public class PostNotFound extends RuntimeException {

    private static final String MESSAGE = "카드가 존재하지 않습니다.";

    public PostNotFound() {
        super(MESSAGE);
    }

}
