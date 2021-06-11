package com.testproject.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class Users {
    @Id
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private byte role;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsersQuestionary> usersQuestionaries;

    public Users(){}
    public Users(String login, String password, byte role)
    {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public byte getRole() {
        return role;
    }

    public Set<UsersQuestionary> getUsersQuestionaries() { return usersQuestionaries; }

    public void setUsersQuestionaries(Set<UsersQuestionary> usersQuestionaries) {this.usersQuestionaries =
            usersQuestionaries;}

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "{ \"login\": \"" + this.login + "\", \"password\": \"" + this.password + "\"}";
    }
}
