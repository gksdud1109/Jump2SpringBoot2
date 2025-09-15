package com.jump2springboot2.question.service;

import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.question.exception.DataNotFoundException;
import com.jump2springboot2.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new DataNotFoundException("질문이 없습니다."));
    }
}
