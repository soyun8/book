package com.spring.book.service;

import com.spring.book.exception.BusinessException;
import com.spring.book.exception.ErrorCode;
import com.spring.book.request.CardRequest;
import com.spring.book.entity.Card;
import com.spring.book.entity.Emotions;
import com.spring.book.repository.CardRepository;
import com.spring.book.repository.EmotionRepository;
import com.spring.book.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.List;

@Service
@Slf4j
public class EmotionService {

    @Autowired
    private EmotionRepository emotionRepository;

    @Autowired
    private CardRepository cardRepository;

    /**
     * 감정단어 GET
     * @return 감정단어 List
     */
    public List<Emotions> getEmotions() {
        List<Emotions> result = emotionRepository.findAll();
        if (result.isEmpty()) {
            throw new BusinessException(ErrorCode.NO_CONTENT);
        }
        return result;

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
                .privateCard(Boolean.FALSE.equals(cardRequest.getPrivateCard()))
                .userEmail(cardRequest.getUserEmail())
                .nickName(cardRequest.getNickName())
                .build();
    }

    // 빈값 처리
    private String getAnswer(List<String> answers, int idx) {
        return idx < answers.size() ? answers.get(idx) : "";
    }
}
