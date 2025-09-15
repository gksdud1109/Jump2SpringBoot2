package com.jump2springboot2.answer.controller;

import com.jump2springboot2.answer.service.AnswerService;
import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable Long id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        return "redirect:/question/detail/%s".formatted(question.getId());
    }
}
