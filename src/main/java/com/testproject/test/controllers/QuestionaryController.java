package com.testproject.test.controllers;

import com.testproject.test.model.Questionary;
import com.testproject.test.repos.QuestionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class QuestionaryController {
    @Autowired
    private QuestionaryRepo questionaryRepo;

    @GetMapping("/questionaries/{userName}")
    public Iterable<Questionary> questionaries(@PathVariable(name = "userName") String userName){
        return questionaryRepo.findAll();
        
    }



}
