package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_answer;
    @Column
    private String formulation;
    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    public Answer(){}
    public Answer(int id_answer, String formulation, Question question)
    {
        this.question = question;
        this.id_answer = id_answer;
        this.formulation = formulation;
    }

    public Answer(String formulation, Question question)
    {
        this.question = question;
        this.formulation = formulation;
    }

    public Question getQuestion() { return question; }

    public int getId_answer() {
        return id_answer;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setQuestion(Question question) { this.question = question; }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }
}
