package com.spring.book.service;

import com.spring.book.repository.MemberRepository;
import com.spring.book.request.LoginRequest;
import com.spring.book.response.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    /*
    * 로그인 요청하기
    * */
    public LoginResponse login(LoginRequest loginReq) {
        SecretKey key = Jwts.SIG.HS256.key().build();
        String jws = Jwts.builder().subject("emotion").signWith(key).compact();
//        return memberRepository.findByUserEmail(loginReq.getUserEmail());
        return LoginResponse.builder()
                .accessToken(jws)
                .userEmail(loginReq.getUserEmail())
                .build();
    }


}
