package com.jump2springboot2.answer.service;


import com.jump2springboot2.answer.entity.Answer;
import com.jump2springboot2.answer.repository.AnswerRepository;
import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content, SiteUser author){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        answerRepository.save(answer);
    }
}
