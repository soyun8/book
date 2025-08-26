package com.spring.book.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.book.request.CardRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("감정단어 리스트 GET")
    void getEmotion() throws Exception {
        mockMvc.perform(get("/emotions"))
                .andExpect(status().isOk())
                .andDo(print());
    }

//    @Test
//    @DisplayName("감정단어 리스트 조회 실패")
//    void getEmotionError() throws Exception {
//        mockMvc.perform(get("/emotions"))
//                .andExpect(status().is5xxServerError())
//                .andDo(print());
//    }


    @Test
    @DisplayName("감정카드 저장하기")
    void cardSave() throws Exception {
        CardRequest cardRequest = CardRequest.builder()
                .word("재미있는")
                .answers(List.of("1", "2", "3"))
                .build();
        mockMvc.perform(post("/card/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cardRequest)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}