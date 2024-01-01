package com.neobis.neo_quiz.controller;

import com.neobis.neo_quiz.entity.dto.QuestionResponse;
import com.neobis.neo_quiz.entity.dto.QuizResponse;
import com.neobis.neo_quiz.service.QuizService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class QuizController {

    QuizService quizService;

    @GetMapping()
    public List<QuizResponse> getALlQuiz() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/questions")
    public List<QuestionResponse> getALlQuiz(@RequestParam String name) {
        return quizService.getQuestions(name);
    }
}
