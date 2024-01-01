package com.neobis.neo_quiz.controller;

import com.neobis.neo_quiz.entity.dto.ArticleFullResponse;
import com.neobis.neo_quiz.entity.dto.ArticleResponse;
import com.neobis.neo_quiz.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "ARTICLE CONTROLLER", description = "USES FOR GETTING ARTICLES OR ARTICLES DESCRIPTIONS")
public class ArticleController {
    ArticleService articleService;

    @GetMapping("/find")
    @Operation(summary = "FIND ARTICLE", description = "FINDS ALL ARTICLES BY NAME AND GENRE IF GIVEN")
    public List<ArticleResponse> findAllByNameAndGenre(@Parameter(name = "NAME OF ARTICLE")
                                                           @RequestParam String name,
                                                       @Parameter(name = "NAME OF GENRE", description = "NOT REQUIRED, USES FOR FILTERING")
                                                           @RequestParam(required = false) String genre) {
        return articleService.findArticleByName(name, genre);
    }

    @GetMapping("/all")
    @Operation(summary = "GET ALL ARTICLES", description = "GETS ALL ARTICLES BY USING PAGINATION")
    public Set<ArticleResponse> getAllArticles(@Parameter(name = "PAGE NUMBER")
                                                   @RequestParam Optional<Integer> pageNumber,
                                               @Parameter(name = "PAGE ITEM AMOUNT")
                                                   @RequestParam Optional<Integer> pageSize ) {
        int page = pageNumber.filter(p -> p >= 1).map(p -> p - 1).orElse(0);
        int amount = pageSize.orElse(1);
        return articleService.getAllArticle(PageRequest.of(page, amount));
    }

    @GetMapping("/description")
    @Operation(summary = "GET ARTICLE BY NAME", description = "GETS FULL ARTICLE BY USING NAME")
    public ArticleFullResponse getAllArticles(@Parameter(name = "NAME OF ARTICLE")
                                                  @RequestParam String name ) {
        return articleService.getArticleDescriptionByName(name);
    }
}
