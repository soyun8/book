package com.spring.book.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor  // JPA 필수
@Table(name = "card", schema = "book")
@Getter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // INSERT 후 ID 생성
    @Column(name = "seq", nullable = false)
    private Long id;

    @Column(name = "word")
    private String word;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "answer4")
    private String answer4;

    @Column(name = "answer5")
    private String answer5;

    @Column(name = "private")
    private Boolean privateCard;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "nick_name")
    private String nickName;

    @Builder
    public Card(String word, String answer1, String answer2, String answer3, String answer4, String answer5, Boolean privateCard, String userEmail, String nickName) {
        this.word = word;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.privateCard = privateCard;
        this.userEmail = userEmail;
        this.nickName = nickName;
    }
}
