package com.neobis.neo_quiz.entity.dto;

import com.neobis.neo_quiz.entity.enums.Genre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizResponse {
    String name;
    Genre genre;
    String imageUrl;
    int questionAmount;
}
