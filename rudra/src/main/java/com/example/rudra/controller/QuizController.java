package com.example.rudra.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rudra.model.Question;
import com.example.rudra.model.UserAnswer;
import com.example.rudra.repository.UserAnswerRepository;
import com.example.rudra.service.QuizService;

import java.util.List;
import java.util.Map;

@Controller
public class QuizController {
    private final QuizService quizService;
    private final UserAnswerRepository userAnswerRepository;

    public QuizController(QuizService quizService, UserAnswerRepository userAnswerRepository) {
        this.quizService = quizService;
        this.userAnswerRepository = userAnswerRepository;
    }

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        List<Question> questions = quizService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "quiz";
    }

    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> allAnswers, Model model) {
        List<Question> questions = quizService.getAllQuestions();
        int correctCount = 0;
        int incorrectCount = 0;

        for (Question question : questions) {
        
            String userAnswer = allAnswers.get("answer_" + question.getId());

       
            if (userAnswer != null && userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                correctCount++;
            } else {
                incorrectCount++;
            }
        }

        model.addAttribute("correctCount", correctCount);
        model.addAttribute("incorrectCount", incorrectCount);
        return "result";
    }
}