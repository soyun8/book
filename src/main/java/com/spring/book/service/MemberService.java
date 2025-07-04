package com.spring.book.service;

import com.spring.book.entity.Member;
import com.spring.book.repository.MemberRepository;
import com.spring.book.request.LoginRequest;
import com.spring.book.response.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    /*
    * 로그인 요청하기
    * */
    public Member login(LoginRequest loginReq) {
        return memberRepository.findByUserEmail(loginReq.getUserEmail());
    }
}
