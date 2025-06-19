package com.spring.book.controller;

import com.spring.book.dto.Emotions;
import com.spring.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping("/emotions")
    public List<Emotions> getEmotion() {
        return bookService.getEmotions();
    }
}
