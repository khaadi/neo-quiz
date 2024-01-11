package com.neobis.neo_quiz.controller;

import com.neobis.neo_quiz.entity.dto.QuestionResponse;
import com.neobis.neo_quiz.entity.dto.QuizResponse;
import com.neobis.neo_quiz.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Tag(name = "QUIZ CONTROLLER", description = "USES FOR GETTING QUIZZES AND QUESTIONS OF QUIZZES")
public class QuizController {

    QuizService quizService;

    @GetMapping()
    @Operation(summary = "GET ALL QUIZZES", description = "GET ALL QUIZZES BUT NOT MUCH LoL :)")
    public List<QuizResponse> getALlQuiz() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/questions")
    @Operation(summary = "GET ALL QUESTIONS", description = "GET ALL QUESTIONS BY QUIZ NAME, USE GIVEN NAME OF QUIZ")
    public List<QuestionResponse> getALlQuiz(@Parameter(name = "name") @RequestParam String name) {
        return quizService.getQuestions(name);
    }
}
