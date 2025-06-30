package com.spring.book.request;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
public class CardRequest {

    @NonNull
    private String word;
    private List<String> answers;

    @Builder
    public CardRequest(@NonNull String word, @NonNull List<String> answers) {
        this.word = word;
        this.answers = answers;
    }
}
