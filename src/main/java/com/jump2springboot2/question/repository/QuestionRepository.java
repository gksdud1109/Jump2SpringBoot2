package com.jump2springboot2.question.repository;

import com.jump2springboot2.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
