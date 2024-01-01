package com.neobis.neo_quiz.service;

import com.neobis.neo_quiz.entity.Question;
import com.neobis.neo_quiz.entity.Quiz;
import com.neobis.neo_quiz.entity.dto.QuestionResponse;
import com.neobis.neo_quiz.entity.dto.QuizResponse;
import com.neobis.neo_quiz.exception.NotFoundException;
import com.neobis.neo_quiz.repository.QuizRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuizService {

    QuizRepository quizRepository;

    public List<QuizResponse> getAllQuizzes() {
        return quizRepository.findAll().stream().map(this::mapToQuizResponse).toList();
    }

    public List<QuestionResponse> getQuestions(String name) {
        Quiz quiz = quizRepository.findByName(name).orElseThrow(
                () -> new NotFoundException("Quiz not found by name = " + name)
        );
        return quiz.getQuestions().stream().map(this::mapToQuestionResponse).toList();
    }

    private QuizResponse mapToQuizResponse(Quiz quiz) {
        return QuizResponse.builder()
                .name(quiz.getName())
                .genre(quiz.getGenre())
                .build();
    }

    private QuestionResponse mapToQuestionResponse(Question question) {
        return QuestionResponse.builder()
                .name(question.getName())
                .trueAnswer(question.getTrueAnswer())
                .falseAnswerOne(question.getFalseAnswerOne())
                .falseAnswerTwo(question.getFalseAnswerTwo())
                .falseAnswerThree(question.getFalseAnswerThree())
                .build();
    }
}
