package com.jump2springboot2.answer.controller;

import com.jump2springboot2.answer.entity.AnswerForm;
import com.jump2springboot2.answer.service.AnswerService;
import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.question.service.QuestionService;
import com.jump2springboot2.user.entity.SiteUser;
import com.jump2springboot2.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(
            Model model, @PathVariable Long id,
            @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        Question question = questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());

        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }

        answerService.create(question, answerForm.getContent(), siteUser);
        return "redirect:/question/detail/%s".formatted(question.getId());
    }
}
