package com.neobis.neo_quiz.model;

import com.neobis.neo_quiz.model.enums.Genre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Enumerated(value = EnumType.STRING)
    Genre genre;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "article", orphanRemoval = true)
    ArticleDescription articleDescription;
}


