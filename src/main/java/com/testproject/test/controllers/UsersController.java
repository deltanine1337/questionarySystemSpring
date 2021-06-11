package com.testproject.test.controllers;

import com.testproject.test.model.Answer;
import com.testproject.test.model.Question;
import com.testproject.test.model.Questionary;
import com.testproject.test.model.Users;
import com.testproject.test.repos.AnswerRepo;
import com.testproject.test.repos.QuestionRepo;
import com.testproject.test.repos.QuestionaryRepo;
import com.testproject.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
public class UsersController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    QuestionaryRepo questionaryRepo;
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    AnswerRepo answerRepo;

    @GetMapping("/insert")
    public String insert () {
        try {
            Questionary qy1 = new Questionary("Анкета школьника");
            Questionary qy2 = new Questionary("Анкета студента");
            Question q1 = new Question("В какой школе ты учишься?", 1);
            Question q2 = new Question("Какие предметы тебе больше нравятся?", 2);
            Question q3 = new Question("Какой твой любимый цвет?", 1);
            Question q4 = new Question("Тебе нравится еда в столовой?", 1);
            Question q5 = new Question("На каком курсе ты учишься?", 1);
            Question q6 = new Question("Тебе удалось закрыть сессию на отличные оценки?", 1);
            Question q7 = new Question("Какие мероприятия посещаешь?", 2);
            HashSet<Question> questions1 = new HashSet<>();
            HashSet<Question> questions2 = new HashSet<>();
            HashSet<Questionary> questionaries1 = new HashSet<>();
            HashSet<Questionary> questionaries2 = new HashSet<>();
            questions1.add(q1);
            questions1.add(q2);
            questions1.add(q3);
            questions1.add(q4);
            questions2.add(q5);
            questions2.add(q6);
            questions2.add(q7);
            questionaries1.add(qy1);
            questionaries2.add(qy2);
            qy1.setQuestions(questions1);
            qy2.setQuestions(questions2);
            questionRepo.save(q1);
            questionRepo.save(q2);
            questionRepo.save(q3);
            questionRepo.save(q4);
            questionRepo.save(q5);
            questionRepo.save(q6);
            questionRepo.save(q7);
            questionaryRepo.save(qy1);
            questionaryRepo.save(qy2);
            answerRepo.save(new Answer("Начальная", q1));
            answerRepo.save(new Answer("Средняя", q1));
            answerRepo.save(new Answer("Старшая", q1));
            answerRepo.save(new Answer("Математика", q2));
            answerRepo.save(new Answer("Литература", q2));
            answerRepo.save(new Answer("Русский язык", q2));
            answerRepo.save(new Answer("Синий", q3));
            answerRepo.save(new Answer("Зелёный", q3));
            answerRepo.save(new Answer("Красный", q3));
            answerRepo.save(new Answer("Фиолетовый", q3));
            answerRepo.save(new Answer("Да", q4));
            answerRepo.save(new Answer("Нет", q4));
            answerRepo.save(new Answer("Первый", q5));
            answerRepo.save(new Answer("Второй", q5));
            answerRepo.save(new Answer("Третий", q5));
            answerRepo.save(new Answer("Четвёртый", q5));
            answerRepo.save(new Answer("Да", q6));
            answerRepo.save(new Answer("Нет", q6));
            answerRepo.save(new Answer("СтудВесна", q7));
            answerRepo.save(new Answer("Хеллоуин", q7));
            answerRepo.save(new Answer("Кубок Декана", q7));
            return "good";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<Users> register( @RequestBody Users users) {
        userRepo.save(new Users(users.getLogin(), "", (byte)1));
        return ResponseEntity.ok().body(users);
    }
}
