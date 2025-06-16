package com.spring.book.service;

import com.spring.book.dto.Emotions;
import com.spring.book.repository.EmotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private EmotionRepository emotionRepository;



    public List<Emotions> getEmotions() {
        return emotionRepository.findAll();
    }
}
