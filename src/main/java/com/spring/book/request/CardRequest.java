package com.spring.book.request;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
public class CardRequest {

    @NonNull
    private String word;
    private List<String> answers;
    private Boolean privateCard;
    private String userEmail;
    private String nickName;


    @Builder
    public CardRequest(@NonNull String word, @NonNull List<String> answers, Boolean privateCard, String userEmail, String nickName) {
        this.word = word;
        this.answers = answers;
        this.privateCard = privateCard;
        this.userEmail = userEmail;
        this.nickName = nickName;
    }

}
