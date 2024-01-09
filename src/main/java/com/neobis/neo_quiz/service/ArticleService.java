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

import java.util.List;
import java.util.Set;
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
                .description(article.getArticleDescription().getArticleFullDescription())
                .build();
    }

    public List<ArticleResponse> findArticleByName(String name, String genre) {
        if (genre == null) genre = "";
        if (name == null) name = "";
        return articleRepository.findByArticleName(name, genre).stream().map(this::mapToArticleResponse).toList();
    }

    private ArticleResponse mapToArticleResponse(Article article) {
        return ArticleResponse.builder()
                .name(article.getName())
                .genre(article.getGenre())
                .build();
    }
}
