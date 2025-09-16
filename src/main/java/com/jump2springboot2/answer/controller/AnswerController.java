package com.jump2springboot2.answer.controller;

import com.jump2springboot2.answer.entity.AnswerForm;
import com.jump2springboot2.answer.service.AnswerService;
import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(
            Model model, @PathVariable Long id,
            @Valid AnswerForm answerForm, BindingResult bindingResult) {
        Question question = questionService.getQuestion(id);

        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }

        answerService.create(question, answerForm.getContent());
        return "redirect:/question/detail/%s".formatted(question.getId());
    }
}
