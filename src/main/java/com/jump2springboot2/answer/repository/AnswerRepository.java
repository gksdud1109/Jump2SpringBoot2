package com.jump2springboot2.answer.repository;

import com.jump2springboot2.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Question, Long> {
}
