package com.spring.book.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 엔티티
 */
@Entity
@Getter
@NoArgsConstructor
@Table(name = "member", schema = "book")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long seq;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public Member(String userEmail, String password, String name, String nickname) {
        this.userEmail = userEmail;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }
}
