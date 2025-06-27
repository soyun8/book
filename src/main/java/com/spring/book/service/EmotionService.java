package com.spring.book.service;

import com.spring.book.dto.CardRequest;
import com.spring.book.entity.Card;
import com.spring.book.entity.Emotions;
import com.spring.book.repository.CardRepository;
import com.spring.book.repository.EmotionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmotionService {

    @Autowired
    private EmotionRepository emotionRepository;

    @Autowired
    private CardRepository cardRepository;



    public List<Emotions> getEmotions() {
        return emotionRepository.findAll();
    }


    public Card cardSave(CardRequest cardRequest) {
        // 프론트단에서 기본적으로 값이 없으면 "" 넘어옴
        // 하지만 백단에서도 처리해줘야 한다
//        return cardRepository.save(setCard(cardRequest));
        return null;
    }

    private Card setCard(CardRequest cardRequest) {
        return Card.builder()
                .word(cardRequest.getWord())
                .answer1(getAnswer(cardRequest.getAnswers(), 0))
                .answer2(getAnswer(cardRequest.getAnswers(), 1))
                .answer3(getAnswer(cardRequest.getAnswers(), 2))
                .answer4(getAnswer(cardRequest.getAnswers(), 3))
                .answer5(getAnswer(cardRequest.getAnswers(), 4))
                .build();
    }

    // 빈값 처리
    private String getAnswer(List<String> answers, int idx) {
        return idx < answers.size() ? answers.get(idx) : "";
    }
}
