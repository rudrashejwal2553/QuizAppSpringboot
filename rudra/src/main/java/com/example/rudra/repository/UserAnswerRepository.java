package com.example.rudra.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rudra.model.UserAnswer;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
}