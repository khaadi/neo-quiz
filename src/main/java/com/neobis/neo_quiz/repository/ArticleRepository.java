package com.neobis.neo_quiz.repository;

import com.neobis.neo_quiz.entity.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    @Query("select a from Article a where a.name like :name")
    Optional<Article> findByName(@Param("name") String name);
    @Query(value = "select * from article a where LOWER(a.name) like LOWER(CONCAT('%', ?1,'%')) " +
            "and a.genre like UPPER(CONCAT('%', ?2,'%'))", nativeQuery = true)
            List<Article> findByArticleName(String name, String genre);
}
