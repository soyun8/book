package com.spring.book.dto;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "emotions", schema = "book")
@Getter
public class Emotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    private Long id;

    @Column(name = "emotion", nullable = false, length = 20, unique = true)
    private String emotion;     // 감정

    @Column(name = "hit", nullable = false)
    private Integer hit;    // 조회수

    // 필수: 기본 생성자
    public Emotions() {}

    // 필수: 전체 필드 초기화하는 생성자
    public Emotions(String emotion, int hit) {
        this.emotion = emotion;
        this.hit = hit;
    }

}