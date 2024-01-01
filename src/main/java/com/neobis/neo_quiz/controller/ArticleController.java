package com.neobis.neo_quiz.controller;

import com.neobis.neo_quiz.entity.dto.ArticleFullResponse;
import com.neobis.neo_quiz.entity.dto.ArticleResponse;
import com.neobis.neo_quiz.service.ArticleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/articles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleController {

    ArticleService articleService;

    @GetMapping()
    public List<ArticleResponse> findAllByNameAndGenre(@RequestParam String name,
                                                       @RequestParam(required = false) String genre) {
        return articleService.findArticleByName(name, genre);
    }

    @GetMapping("/all")
    public Set<ArticleResponse> getAllArticles(@RequestParam Optional<Integer> pageNumber,
                                               @RequestParam Optional<Integer> pageSize ) {
        int page = pageNumber.filter(p -> p >= 1).map(p -> p - 1).orElse(0);
        int amount = pageSize.orElse(1);
        return articleService.getAllArticle(PageRequest.of(page, amount));
    }

    @GetMapping("/description")
    public ArticleFullResponse getAllArticles(@RequestParam String name ) {
        return articleService.getArticleDescriptionByName(name);
    }
}
