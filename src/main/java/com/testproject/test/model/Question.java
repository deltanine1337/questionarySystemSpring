package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id_question;
    @Column
    private String formulation;
    @Column
    private int num_of_answers;
    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private Set<Questionary> questionaries;

    public Question(){}

    public Question(String formulation, int num_of_answers)
    {
        this.formulation = formulation;
        this.num_of_answers = num_of_answers;
    }
    public Question(int id, String formulation, int num_of_answers)
    {
        this.id_question = id;
        this.formulation = formulation;
        this.num_of_answers = num_of_answers;
    }

    public Set<Questionary> getQuestionaries() { return questionaries; }

    public void setQuestionaries(Set<Questionary> questionaries) { this.questionaries = questionaries; }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id) {
        this.id_question = id;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public int getNum_of_answers() {
        return num_of_answers;
    }

    public void setNum_of_answers(int num_of_answers) {
        this.num_of_answers = num_of_answers;
    }
}
