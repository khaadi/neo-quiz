package com.neobis.neo_quiz.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionResponse {
    String name;
    String trueAnswer;
    String falseAnswerOne;
    String falseAnswerTwo;
    String falseAnswerThree;
}
