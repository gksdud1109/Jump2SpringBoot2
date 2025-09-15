package com.jump2springboot2.question.controller;

import com.jump2springboot2.question.entity.Question;
import com.jump2springboot2.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionsList = questionRepository.findAll();
        model.addAttribute("questionList", questionsList);
        return "question_list";
    }
}
