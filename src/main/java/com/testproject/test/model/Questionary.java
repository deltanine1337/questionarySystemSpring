package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "questionary")
public class Questionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id_questionary;
    @Column
    private String name;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "questionary_question",
            joinColumns = @JoinColumn(name = "questionary_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questions;
    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "questionary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsersQuestionary> usersQuestionaries;

    public Questionary(){}

    public Questionary(String name)
    {
        this.name = name;
    }
    public Questionary(int id_questionary, String name)
    {
        this.id_questionary = id_questionary;
        this.name = name;
    }

    public Set<Question> getQuestions() { return questions; }

    public Set<UsersQuestionary> getUsersQuestionaries() { return usersQuestionaries; }

    public void setQuestions(Set<Question> questions) { this.questions = questions; }

    public void setUsersQuestionaries(Set<UsersQuestionary> usersQuestionaries) {
        this.usersQuestionaries = usersQuestionaries;
    }

    public int getId_questionary() {
        return id_questionary;
    }

    public String getName() {
        return name;
    }

    public void setId_questionary(int id_questionary) {
        this.id_questionary = id_questionary;
    }

    public void setName(String name) {
        this.name = name;
    }
}
