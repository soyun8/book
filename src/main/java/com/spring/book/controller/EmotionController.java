package com.spring.book.controller;

import com.spring.book.request.CardRequest;
import com.spring.book.entity.Card;
import com.spring.book.entity.Emotions;
import com.spring.book.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmotionController {

    private final EmotionService emotionService;

    @GetMapping("/emotions")
    public List<Emotions> getEmotion() {
        return emotionService.getEmotions();
    }

    @PostMapping("card/save")
    public Card cardSave(@RequestBody @Validated CardRequest cardRequest) {
        return emotionService.cardSave(cardRequest);
    }
}
