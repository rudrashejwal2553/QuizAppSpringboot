package com.example.rudra.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rudra.model.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {
}