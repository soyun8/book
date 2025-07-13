package com.spring.book.service;

import com.spring.book.repository.MemberRepository;
import com.spring.book.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    public void signIn(LoginRequest loginRequest) {

    }
}
