package com.neobis.neo_quiz.entity;

import com.neobis.neo_quiz.entity.enums.Genre;
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
    @Column(unique = true)
    String name;
    @Enumerated(value = EnumType.STRING)
    Genre genre;
    short timeInMinutes;
    String imageUrl;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "article", orphanRemoval = true)
    ArticleDescription articleDescription;
}


