package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "users_questionary")
public class UsersQuestionary {
    @ManyToOne
    @JoinColumn(name = "login")
    private Users user;
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_questionary")
    private Questionary questionary;
    @Id
    @Column
    private String answers;

    public UsersQuestionary(){}
    public UsersQuestionary(Users user, Questionary questionary, String answers)
    {
        this.user = user;
        this.questionary = questionary;
        this.answers = answers;
    }

    public String getAnswers() {
        return answers;
    }

    public Questionary getQuestionary() {
        return questionary;
    }

    public Users getUser() {
        return user;
    }

    public void setQuestionary(Questionary questionary) {
        this.questionary = questionary;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
