package com.testproject.test.controllers;

import com.testproject.test.model.Answer;
import com.testproject.test.repos.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AnswerController {
    @Autowired
    private AnswerRepo answerRepo;

    @GetMapping("/questionaries/{username}/fill/{qname}")
    public List<Answer> getAnswers(@PathVariable(name = "username") String username,
                                   @PathVariable(name = "qname") String qname) {
        return answerRepo.getAnswersFromQuestionary(qname);
    }
}
