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

    @Builder
    public Card(String word, String answer1, String answer2, String answer3, String answer4, String answer5) {
        this.word = word;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
    }
}
