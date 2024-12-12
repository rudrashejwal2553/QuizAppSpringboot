package com.example.rudra.service;

import org.springframework.stereotype.Service;

import com.example.rudra.model.Question;
import com.example.rudra.repository.QuestionRepository;

import java.util.List;

@Service
public class QuizService {
    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}