package com.neobis.neo_quiz.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "article_full_description", length = 4096)
    String articleFullDescription;
    @OneToOne(fetch = FetchType.EAGER)
    Article article;
}
