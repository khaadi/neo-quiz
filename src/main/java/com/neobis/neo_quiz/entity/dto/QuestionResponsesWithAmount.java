package com.neobis.neo_quiz.entity.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionResponsesWithAmount {
    List<QuestionResponse> responses;
    int amount;
}
