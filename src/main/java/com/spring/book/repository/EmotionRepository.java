package com.spring.book.repository;

import com.spring.book.dto.Emotions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotions, Long> {
    boolean existsByEmotion(String emotionName);
}