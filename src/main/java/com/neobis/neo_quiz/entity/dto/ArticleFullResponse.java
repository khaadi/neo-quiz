package com.neobis.neo_quiz.entity.dto;

import com.neobis.neo_quiz.entity.enums.Genre;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleFullResponse {
    String name;
    Genre genre;
    String description;
}
