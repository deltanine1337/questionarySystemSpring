package com.testproject.test.controllers;

import com.testproject.test.model.Answer;
import com.testproject.test.model.UsersQuestionary;
import com.testproject.test.repos.AnswerRepo;
import com.testproject.test.repos.QuestionaryRepo;
import com.testproject.test.repos.UserRepo;
import com.testproject.test.repos.UsersQuestionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UsersQuestionaryController {
    @Autowired
    private UsersQuestionaryRepo usersQuestionaryRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private QuestionaryRepo questionaryRepo;
    @Autowired
    private AnswerRepo answerRepo;

    @PostMapping(value = "/questionaries/{username}/fill/{qname}/save")
    public @ResponseBody
    ResponseEntity<UsersQuestionary> saveQuest(@RequestBody UsersQuestionary usersQuestionary,
                                               @PathVariable(name = "username") String username,
                                               @PathVariable(name = "qname") String qname) {
        usersQuestionary.setUser(userRepo.getUsersByLogin(username).get(0));
        usersQuestionary.setQuestionary(questionaryRepo.getQuestByName(qname).get(0));
        usersQuestionaryRepo.save(usersQuestionary);
        return ResponseEntity.ok().body(usersQuestionary);
    }

    @GetMapping("/questionaries/{username}/answers/{qname}")
    public Iterable<Answer> getUserAnswers(@PathVariable(name = "username") String username,
                                           @PathVariable(name = "qname") String qname) {
        List<Answer> allAnswers = new ArrayList<Answer>();
        try {
            int qid = questionaryRepo.getQuestByName(qname).get(0).getId_questionary();
            String answers = usersQuestionaryRepo.getUserAnswers(username, qid).get(0).getAnswers();
            String[] answersIds = answers.split("@");

            for (String a : answersIds) {
                allAnswers.add(answerRepo.getAnswersById(Integer.parseInt(a)).get(0));
            }
        }
        catch (Exception e) {}
        return allAnswers;
    }

    @GetMapping("/usersquestionaries/getall")
    public Iterable<UsersQuestionary> getAllUsersQuestionaries() {
        return usersQuestionaryRepo.findAll();
    }
}
