package com.spring.book.controller;

import com.spring.book.entity.Member;
import com.spring.book.request.LoginRequest;
import com.spring.book.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public Member login(@RequestBody LoginRequest loginReq) {
        return memberService.login(loginReq);
    }
}
