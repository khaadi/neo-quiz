package com.neobis.neo_quiz.repository;

import com.neobis.neo_quiz.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Optional<Article> findByName(String name);
    @Query(value = "select a from article a where LOWER(a.name) like LOWER(CONCAT('%', ?1,'%')) " +
            "and a.genre like LOWER(CONCAT('%', ?2,'%'))", nativeQuery = true)
    List<Article> findByArticleName(String name, String genre);
}
