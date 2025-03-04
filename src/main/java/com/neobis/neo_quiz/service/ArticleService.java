package com.neobis.neo_quiz.service;

import com.neobis.neo_quiz.entity.Article;
import com.neobis.neo_quiz.entity.dto.ArticleFullResponse;
import com.neobis.neo_quiz.entity.dto.ArticleResponse;
import com.neobis.neo_quiz.exception.NotFoundException;
import com.neobis.neo_quiz.repository.ArticleRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleService {
    ArticleRepository articleRepository;

    public Set<ArticleResponse> getAllArticle(Pageable pageable) {
        return articleRepository.findAll(pageable).stream()
                .map(this::mapToArticleResponse).collect(Collectors.toSet());
    }

    public ArticleFullResponse getArticleDescriptionByName(String name) {
        Article article = articleRepository.findByName(name).orElseThrow(
                () -> new NotFoundException("Article not found by name = " + name)
        );
        return ArticleFullResponse.builder()
                .name(article.getName())
                .genre(article.getGenre())
                .imageUrl(article.getImageUrl())
                .time(article.getTimeInMinutes())
                .description(article.getArticleDescription().getArticleFullDescription())
                .build();
    }

    public List<ArticleResponse> findArticleByName(String name, String[] genre) {
        return Arrays.stream(genre)
                .map(g -> articleRepository.findByArticleName(name, g).stream()
                        .map(this::mapToArticleResponse)
                        .collect(Collectors.toSet()))
                .flatMap(Set::stream).distinct().collect(Collectors.toList());
    }

    private ArticleResponse mapToArticleResponse(Article article) {
        return ArticleResponse.builder()
                .name(article.getName())
                .time(article.getTimeInMinutes())
                .imageUrl(article.getImageUrl())
                .genre(article.getGenre())
                .build();
    }
}
