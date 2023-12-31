package com.neobis.neo_quiz.model;

import com.neobis.neo_quiz.model.enums.Genre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    Genre genre;
    @Column(name = "question_count")
    Integer questionCount;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "quiz")
    Set<Question> questions;
}
